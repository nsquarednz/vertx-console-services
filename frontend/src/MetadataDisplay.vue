<template>
    <dropdown v-if="displayMetadata" class="table-view-pf-btn metadata-display dropdown dropdown-kebab-pf">
        <div slot="button">View</div>
        <div slot="dropdown-menu" class="dropdown-menu dropdown-menu-right dropdown-menu-container">
            <code v-html="formattedRowString"></code>
        </div>
    </dropdown>
    <div v-else class="table-view-pf-btn">
        <button class="btn btn-default" disabled>None</button>
    </div>
</template>

<style lang="scss">
.metadata-display.btn-group {
    width: 100%;

    .btn {
        border-radius: 0;
    }

    .caret {
        display: none;
    }

    .dropdown-menu-container {
        padding: 10px;
    }

    code {
        white-space: pre;
        background: none;
        padding: 0;
    }

    .json-markup {
        color: #aaa;
    }

    .json-markup-key {
        color: #000;
        font-weight: bold;
    }

    .json-markup-bool {
        color: firebrick;
    }
    .json-markup-string {
        color: green;
    }
    .json-markup-null {
        color: gray;
    }
    .json-markup-number {
        color: blue;
    }
}
</style>

<script>
import jsonMarkup from 'json-markup';

const hasMetadata = row => row.metadata !== undefined && Object.keys(row.metadata).length > 0;

export default {
    props: {
        row: Object
    },
    options: {
        asPlainText(row) {
            return hasMetadata(row) ? 'View' : 'None';
        }
    },
    computed: {
        displayMetadata() {
            return hasMetadata(this.row);
        },
        formattedRowString() {
            return jsonMarkup(this.row.metadata);
        }
    }
}
</script>
