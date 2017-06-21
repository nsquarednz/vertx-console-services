<template>
<code>{{ row.registration }}</code>
</template>

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
