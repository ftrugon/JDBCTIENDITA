import java.sql.SQLException

class ProductDAO {


    fun createProduct(product:Product):Product?{
        val sql = "INSERT INTO PRODUCTS (id, name, price,description,brand,category) VALUES (?, ?, ?, ?, ?, ?)"
        return try{
            DataBase.getConnection().use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setString(1, product.id.toString())
                    stmt.setString(2, product.name)
                    stmt.setString(3, product.price.toString())
                    stmt.setString(4, product.desc)
                    stmt.setString(5, product.brand)
                    stmt.setString(6, product.category)
                    val rs = stmt.executeUpdate()

                    if (rs == 1){
                        product
                    }else {
                        null
                    }

                }
            }
        }catch (e: SQLException){
            null
        }
    }


}