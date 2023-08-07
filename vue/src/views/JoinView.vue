<script setup>
import Header from '@/components/Header.vue';
</script>

<template>
    <Header />

    <main class="join-main">
        <form action="" class="join-form">
            <fieldset>
                <legend class="join-legend">회원가입</legend>
                
                <div class="join-box">
                    <p class="join-info-text">아래의 내용을 입력해주세요.</p>
                    <input type="text" placeholder="이름">
                    <input type="text" placeholder="이메일">
                    <div class="email-authentication-box">
                        <input type="text" placeholder="인증번호">
                        <button>전송</button>    
                    </div>
                    <input type="text" placeholder="비밀번호">
                    <input type="text" placeholder="비밀번호 확인">
                    <div class="agree-box">
                        <input type="checkbox" class="agree-box-checkbox">
                        <label for="">인증약관 동의</label>
                        <p><a href="">내용 확인</a></p>
                    </div>
                </div>

                <button class="join-button">회원가입</button>
            </fieldset>
        </form>
    </main>

</template>

<style>

.join-main {
    width: 100%;
    height: auto;
    display: flex;
    justify-content: center;
}

.join-info-text {
    margin-top: 2.19rem;
    margin-left: 1.25rem;
    margin-bottom: 0.31rem;
    text-align: left;
    
    /* M3/label/medium */
    font-family: Roboto;
    font-size: 0.75rem;
    font-style: normal;
    font-weight: 500;
    line-height: 1rem; /* 133.333% */
    letter-spacing: 0.03125rem;
}

.join-form {
    width: auto;
    height: auto;
}

.join-box {
    border-radius: 0.25rem;
    border: 1px solid #79747E;
}

.join-legend {
    text-align: left;
    color: #6750A4;
    font-weight: bold;
    /* M3/label/large - prominent */
    font-family: Roboto;
    font-size: 1rem;
    font-style: normal;
    font-weight: 600;
    line-height: 1.25rem; /* 142.857% */
    letter-spacing: 0.00625rem;
}

.email-authentication-box {
    margin: 0.31rem 1.25rem;
    display: flex;
    align-items: center;
}

.email-authentication-box > input {
    display: inline-block;
    width: 11.875rem;
    height: 2.5rem;
    padding: 0.5rem 0rem 0.5rem 1rem;

    border-radius: 0.25rem;
    border: 1.5px solid #79747E;   
}

.email-authentication-box > button {
    display: inline-block;
    width: 6.25rem;
    margin-left: 0.62rem;
    flex-direction: column;
    align-items: center;
    padding: 0.625rem 1.5rem;
    border-radius: 6.25rem;
    border: none;
    color:#ffffff;
    background-color: #6750A4;
}

.join-box > input {
    display: flex;
    width: 18.75rem;
    height: 2.5rem;

    margin: 0.31rem 1.25rem;

    padding: 0.5rem 0rem 0.5rem 1rem;
    align-items: center;
    align-self: stretch;

    border-radius: 0.25rem;
    border: 1.5px solid #79747E;
}

.agree-box {
    display: flex;
    width: 18.75rem;
    height: 2.5rem;
    margin: 0.31rem 1.25rem 2.10rem 1.25rem;
    background-color: #ffffff;

    padding: 0.5rem 0rem 0.5rem 1rem;
    align-items: center;
    align-self: stretch;

    border-radius: 0.25rem;
    border: 1.5px solid #79747E;
}

.agree-box > p {
    margin-left: 6.0rem;

    /* M3/label/large */
    font-family: Roboto;
    font-size: 0.875rem;
    font-style: normal;
    font-weight: 500;
    line-height: 1.25rem; /* 142.857% */
    letter-spacing: 0.00625rem;
}

.agree-box a {
    text-decoration: none;
}

.agree-box > label {
    margin-left: 0.75rem;

    font-family: Roboto;
    font-size: 0.875rem;
    font-style: normal;
    font-weight: 500;
    line-height: 1.25rem; /* 142.857% */
    letter-spacing: 0.00625rem;
}

.agree-box-checkbox {
    padding: 0.6875rem;
    width: 1.3rem;
    height: 1.3rem;
    justify-content: center;
    align-items: center;
    border-radius: 6.25rem;
}

.agree-box-checkbox[type=checkbox] {
    background-repeat: no-repeat;
    background-image: url('../assets/images/checkbox.svg');
}

.join-button {
    display: inline-block;
    width: 18.75rem;
    margin-top: 0.62rem;
    flex-direction: column;
    align-items: center;
    padding: 0.625rem 1.5rem;
    border-radius: 6.25rem;
    border: none;
    color:#ffffff;
    background-color: #6750A4;
}

</style>