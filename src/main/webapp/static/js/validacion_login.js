const formL = document.getElementById('formulario__login');
const correoLogin = document.getElementById('correo_login');
const contrasenaLogin = document.getElementById('contrasena_login');
const btnIniciarSesion = document.getElementById('btn_iniciar-sesion_form');

const setErrorL = (element, message) => {
  const inputControl = element.parentElement;
  const errorDisplay = inputControl.querySelector('.error');

  errorDisplay.innerText = message;
  inputControl.classList.add('error-control');
  inputControl.classList.remove('success-control');
};

const setSuccessL = element => {
  const inputControl = element.parentElement;
  const errorDisplay = inputControl.querySelector('.error');

  errorDisplay.innerText = '';
  inputControl.classList.add('success-control');
  inputControl.classList.remove('error-control');
};

const isValidEmailL = email => {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
};

const validateLoginInputsL = () => {
    const correoValue = correoLogin.value.trim();
    const contrasenaValue = contrasenaLogin.value.trim();

    if (correoValue === '') {
        setError(correoLogin, 'Se requiere su correo');
    } else if (!isValidEmailL(correoValue)) {
        setError(correoLogin, 'Brinde un correo correcto');
    } else {
        setSuccess(correoLogin);
    }

    if (contrasenaValue === '') {
        setError(contrasenaLogin, 'Contraseña requerida');
    } else {
        setSuccess(contrasenaLogin);
    }
};