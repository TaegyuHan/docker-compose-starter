<!-- src/views/About.vue -->
<template>
    <header class="header">
      <div class="header-center-box">
        <router-link to="/">스타링크 홈</router-link>
      </div>
    </header>
</template>


<style>

  header {
    width: 100%;
    height: 6.25rem;
    display: flex;
    justify-content: center;
  }

  .header-center-box {
    min-width: 70.5rem;
    width: 70.5rem;
    height: 6.25rem;
  }
  
  .header-center-box > a {
    display: inline-block;
    float: right;
    margin: 2.5rem 0.625rem;
    justify-content: center;
    align-items: center;

    color: var(--m-3-sys-dark-outline-variant, #49454F);

    text-decoration: none;

    /* M3/title/small */
    font-family: Roboto;
    font-size: 0.875rem;
    font-style: normal;
    font-weight: 500;
    line-height: 1.25rem; /* 142.857% */
    letter-spacing: 0.00625rem;
  }

</style>