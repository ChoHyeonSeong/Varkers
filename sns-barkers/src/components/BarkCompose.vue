<template>
  <Teleport to="body">
    <form @submit.prevent="registerBark">
      <modal :show="showModal" @close="$emit('close')">
        <template #header>
          <h3>Bark Register</h3>
        </template>
        <template #body>
          <input type="text" v-model="bark" />
        </template>
        <template #footer>
          <button type="submit">Register</button>
        </template>
      </modal>
    </form>
  </Teleport>
</template>

<script setup>
import { ref } from 'vue';
import Modal from './common/Modal.vue';

const bark = ref('');
const emit = defineEmits(['close']);
const props = defineProps({
  showModal: Boolean,
});

function registerBark() {
  emit('close');
  console.log(bark.value);
}
</script>
