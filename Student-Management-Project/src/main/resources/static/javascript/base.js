/**
 * 
 */

 console.log("Hey the page is working");
 
 function seePassword() {
  var x = document.getElementById("userFormControlInput3");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}