<template>
  <div class="books">
    <BooksList msg="Here will be the list of books"/>
  </div>
</template>

<script>
import BooksList from '@/components/BooksList.vue'
export default {
    name: 'BooksView',
    components: {
        BooksList
    },
    data: function () {
      return{
        books: [],
        error: null,
      };
    },
    mounted() {
      this.fetchBooks();
    },
    methods: {
      fetchBooks() {
        fetch("https://localhost:8080/books/get/all")
        .then((res) => res.json())
        .then((res) => {
          this.books = res;
        })
        .catch((err) => {
          console.log(err);
          this.error = err;
        });
      }
    }
}
</script>

