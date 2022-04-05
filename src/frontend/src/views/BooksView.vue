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
    }
}
</script>

