package com.snapshoes.store.persistense.specifications
import com.snapshoes.store.persistense.entities.Product
import com.snapshoes.store.persistense.entities.ProductGenre
import com.snapshoes.store.persistense.entities.ProductSize
import jakarta.persistence.criteria.JoinType
import org.springframework.data.jpa.domain.Specification

class ProductSpecifications {
    companion object {
        fun hasStoreId(storeId: Long): Specification<Product> {
            return Specification { root, _, criteriaBuilder ->
                criteriaBuilder.equal(root.get<Long>("store").get<Long>("id"), storeId)
            }
        }

        fun hasBrandId(brandId: Long): Specification<Product> {
            return Specification { root, _, criteriaBuilder ->
                criteriaBuilder.equal(root.get<Long>("brand").get<Long>("id"), brandId)
            }
        }

        fun hasName(name: String): Specification<Product> {
            return Specification { root, _, criteriaBuilder ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%${name.lowercase()}%")
            }
        }
    }
}
