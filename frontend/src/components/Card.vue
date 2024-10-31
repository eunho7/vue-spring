<template>
    <div class="card shadow-sm">
        <span class="img" :style="{backgroundImage: `url(${item.imgPath})`}"/>

        <div class="card-body">
            <p class="card-text">{{ item.name }}
                <span class="discount badge bg-danger">
                    {{ item.discountPer }}%
                </span>
            </p>
            
            <div class="d-flex justify-content-between align-items-center">
                <button type="button" class="btn btn-primary">구입하기</button>
                <small class="price text-muted">
                    {{ lib.getNumberFormatted(item.price) }}원
                </small>
                <small class="discount text-danger">
                    {{ lib.getNumberFormatted(item.price * (1 - 0.01*item.discountPer)) }}원
                </small>
            </div>
        </div>
    </div>
</template>

<script>
import lib from '@/scripts/lib.js'

export default {
  name : 'Card',
  props :{
    item : Object
  },
  setup() {
    return {lib}
  }
}
</script>

<style scope>
.card .img {
    display: line-block;
    width: 100%;
    height: 250px;
    background-size: cover;
    background-position: center;
}
.card .card-body .price {
    text-decoration: line-through;
}
</style>

