const form = document.getElementById('formulario__register');
const nombre = document.getElementById('nombres');
const user = document.getElementById('user');
const correo = document.getElementById('correo_register');
const contrasena = document.getElementById('contrasena_register');
const genero = document.getElementById('genero');
const dni = document.getElementById('dni');


const generoOptions = document.querySelectorAll('input[name="genero"]');
let generoValue = '';
for (const option of generoOptions) {
    if (option.checked) {
        generoValue = option.value;
        break;
    }
}

const btnRegistrarse = document.getElementById('btn_registrarse_form');
btnRegistrarse.addEventListener('click', e => {
    e.preventDefault();
    validateInputs();
    
});

const setError = (element, message) => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = message;
    inputControl.classList.add('error');
    inputControl.classList.remove('success');
};

const setSuccess = element => {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = '';
    inputControl.classList.add('success');
    inputControl.classList.remove('error');
};

const isValidEmail = email => {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
};

const validateInputs = () => {
    const nombreValue = nombre.value.trim();
    const userValue = user.value.trim();
    const dniValue = dni.value.trim();
    const correoValue = correo.value.trim();
    const contrasenaValue = contrasena.value.trim();
    let generoValue = '';

    for (const option of generoOptions) {
        if (option.checked) {
            generoValue = option.value;
            break;
        }
    }

    if (nombreValue === '') {
        setError(nombre, 'Sus nombres son requeridos');
    } else {
        setSuccess(nombre);
    }

    if (userValue === '') {
        setError(user, 'Requiere de un nombre de usuario');
    } else {
        setSuccess(user);
    }
    
    if (dniValue === '') {
        setError(dni, 'DNI obligatorio');
    } else if (dniValue.length < 8) {
        setError(dni, 'El DNI tiene 8 caracteres');
    } else {
        setSuccess(dni);
    }

    if (correoValue === '') {
        setError(correo, 'Se requiere su correo');
    } else if (!isValidEmail(correoValue)) {
        setError(correo, 'Brinde un correo correcto');
    } else {
        setSuccess(correo);
    }

    if (contrasenaValue === '') {
        setError(contrasena, 'Contraseña requerida');
    } else if (contrasenaValue.length < 8) {
        setError(contrasena, 'La contraseña debe tener como mínimo 8 caracteres');
    } else {
        setSuccess(contrasena);
    }

    if (generoValue === '') {
        setError(genero, 'Seleccione un género');
    } else {
        setSuccess(genero);
    }
};
