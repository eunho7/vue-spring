<template>
<main class="form-signin w-100 m-auto">
    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

    <div class="form-floating">
      <input type="email" class="form-control" placeholder="name@example.com" v-model="state.form.email">
      <label for="floatingInput">Email address</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" placeholder="Password" v-model="state.form.password">
      <label for="floatingPassword">Password</label>
    </div>

    <div class="form-check text-start my-3">
      <input class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault">
      <label class="form-check-label" for="flexCheckDefault">
        Remember me
      </label>
    </div>
    <button class="btn btn-primary w-100 py-2" @click="submit()">Sign in</button>
</main>
</template>

<script>
import axios from 'axios';
import store from '@/scripts/store'
import router from '@/scripts/router';
import { reactive } from 'vue';

export default {
   setup() {
    const state = reactive({
        form: {
            email: "",
            password: ""
        }
    })
    
    const submit = () => {
        axios.post("/api/account/login", state.form).then((response)=>{
            store.commit('setAccount',response.data);
            router.push({path:'/'})
            window.alert("로그인 되었습니다.");
        })
    }

    return {state, submit}
   }
}
</script>


<style scoped>
.form-signin {
  max-width: 330px;
  padding: 1rem;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>
