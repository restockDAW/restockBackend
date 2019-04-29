$(document).ready(function () {

  var form = document.getElementById("form");
  form.addEventListener('submit', function(event) {
    if (form.checkValidity() === false) {
      event.preventDefault();
      event.stopPropagation();
    }
    form.classList.add('was-validated');
  }, false);

  $('#pas1').click(function(){
    $("#usuari").hide();
    $("#organitzacio").show();
    $('#pas1').removeClass("completed").addClass("active");
    $("#pas2").removeClass("active");
  });

  $('#pas2').click(validar);
  $("#next").click(function(e){
    e.preventDefault();
    validar();
  });

  function validar(){

    var inputs = document.getElementsByTagName("input");
    var valid = true;

    for(var i=0; i < 7; i++){
      if(!inputs[i].checkValidity()){
        valid = false;
      }
    }

    if(valid){
      $("#usuari").show(600);
      $("#organitzacio").hide();
      $('#pas2').addClass("active");
      $("#pas1").removeClass("active").removeClass("warning").addClass("completed");
      $("form").removeClass("was-validated").addClass("needs-validation");

    }
    else{
      for(var i=0; i < inputs.length; i++){
        if(!inputs[i].checkValidity()){
          inputs[i].classList.add(":invalid");
          $("form").addClass("was-validated");
          $("form").removeClass("needs-validation");
        }
      }

      $("#pas1").addClass("warning");
    }
  }

})
