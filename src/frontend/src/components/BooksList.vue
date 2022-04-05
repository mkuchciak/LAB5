<template>
  <div class="books-list">
    <h1>{{ msg }}</h1>
    <h4>Books</h4>
    <!-- <a>
        v-bind:key="book.id"
        v-for="book of books"
        {{book.title}}, {{book.pages}}, {{book.author}}
    </a> -->
  </div>
  
</template>

<script>
export default {
  name: 'BooksList',
  props: {
    msg: String
  },
  data: function () {
      return {
          books: null,
      };
  },
  created() {
      this.fetchData();
  },
  methods: {
      fetchData() {
          fetch("http://localhost:8080/books/get/all")
            .then((res) => res.json())
            .then((res) => (this.books = res))
            .catch((err) => console.log(err));
      }
  }
}
</script>

