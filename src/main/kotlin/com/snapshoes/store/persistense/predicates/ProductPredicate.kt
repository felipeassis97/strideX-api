package com.snapshoes.store.persistense.predicates
import com.snapshoes.store.persistense.entities.Product
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root
import org.springframework.data.jpa.domain.Specification
import java.util.*


class ProductSpecification(
    private val storeId: Long?,
    private val brandId: Long?,
    private val name: String?
) : Specification<Product> {

    override fun toPredicate(
        root: Root<Product>,
        query: CriteriaQuery<*>?,
        criteriaBuilder: CriteriaBuilder
    ): Predicate? {
        val predicates = mutableListOf<Predicate>()

        storeId?.let {
            predicates.add(criteriaBuilder.equal(root.get<Long>("store").get<Long>("id"), it))
        }

        brandId?.let {
            predicates.add(criteriaBuilder.equal(root.get<Long>("brand").get<Long>("id"), it))
        }

        name?.let {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%${it.lowercase(Locale.getDefault())}%"))
        }

        return criteriaBuilder.and(*predicates.toTypedArray())
    }
}
