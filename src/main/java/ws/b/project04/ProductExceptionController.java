/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.b.project04;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author alamnurcahaya
 */

//ControllerAdvice untuk menangani exception jika produk tidak ada
@ControllerAdvice
public class ProductExceptionController {
    // ExceptionHandler digunakan untuk menangani exception mengirim respon ke user
   @ExceptionHandler(value = ProductNotfoundException.class)
   public ResponseEntity<Object> exception(ProductNotfoundException exception) {
       //tampil pesan jika data yang diperbarui tidak ada
      return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
   }
}
