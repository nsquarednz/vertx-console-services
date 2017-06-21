<template>
<span class="registration-text">{{ row.registration }}</span>
</template>

<style lang="scss">
.registration-text {
    font-family: Menlo,Monaco,Consolas,monospace;
}
</style>

<script>
export default {
  props: {
      row: Object
  },
  options: {
      asPlainText(row) {
        return row.registration;
      }
  }
}
</script>
