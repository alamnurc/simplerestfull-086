/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.b.project04;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alamnurcahaya
 */

@RestController
public class ProductServiceController {
   private static Map<String, Product> productRepo = new HashMap<>();
   static {
      //honey adalah bagian dari Product
      Product honey = new Product();
      //beri id pada honey
      honey.setId("1");
      //beri nama pada honey
      honey.setName("Honey");
      productRepo.put(honey.getId(), honey);
      
      Product almond = new Product();
      almond.setId("2");
      almond.setName("Almond");
      productRepo.put(almond.getId(), almond);
   }
   
   //@RequestMapping untuk mengatur Path URL 
   @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
   //@PathVariabel mengatur URL request khusus atau dinamis
   //if else untuk mencari tahu ketersediaan id tersebut
   public ResponseEntity<Object> delete(@PathVariable("id") String id) { 
       if(!productRepo.containsKey(id)){
           return new ResponseEntity<>("Product deleted not found", HttpStatus.OK);
       }
       else{
           productRepo.remove(id);
           return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
       }
   }
   
   //@RequestMapping untuk mengatur Path URL 
   @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
   //@PathVariabel mengatur URL request khusus atau dinamis
   //if else untuk mencari tahu ketersediaan id tersebut
   public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) { 
      if(!productRepo.containsKey(id)){
           return new ResponseEntity<>("Product updated not found", HttpStatus.OK);
       }
       else{
           //hapus data berdasarkan id
           productRepo.remove(id);
           product.setId(id);
           //memperbarui data berdasarkan id
           productRepo.put(id, product);
           return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
       }
   }
   
   //@RequestMapping untuk mengatur Path URL
   @RequestMapping(value = "/products", method = RequestMethod.POST)
   //@PathVariabel mengatur URL request khusus atau dinamis
   //if else untuk mencari tahu ketersediaan id tersebut
   public ResponseEntity<Object> createProduct(@RequestBody @Validated Product product) {
       
       //jika id produk sudah ada, tampilkan pesan "Product not duplicate"
      if(productRepo.containsKey(product.getId())){
           return new ResponseEntity<>("Product not duplicate", HttpStatus.OK);
       }
      //jika id produk belum ada, buat data baru dan tampilkan pesan "Product is created successfully"
       else{
           productRepo.put(product.getId(), product);
           return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
       }
   }
   
   //@RequestMapping untuk mengatur Path URL
   @RequestMapping(value = "/products")
   public ResponseEntity<Object> getProduct() {
      return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
   }
}