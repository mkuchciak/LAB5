<template>
  <div class="books-list">
    <h1>{{ msg }}</h1>
  </div>
</template>

<script>
export default {
  name: 'BooksList',
  props: {
    msg: String
  }
}
</script>
