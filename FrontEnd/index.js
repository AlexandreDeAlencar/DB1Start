var app = new Vue({
  el: '#app',
  data: {
  	title:"Meus estados favoritos",
    message: 'Hello Vue!',
    aula: 'Front End Vue.JS',
    states: 
    [{"id":2,"nome":"Paraná"},
    {"id":3,"nome":"Rio de Janeiro"},
    {"id":4,"nome":"Bahia"},
    {"id":5,"nome":"Santa Catarina"}]
  },
  methods:{
  	setStateName(event){
  		this.stateName = event.target.value
  	},
	addStateList(){
  		const id = this.states.length
  		this.states.push({
  			id: id,
  			nome: this.stateName
  		})
	},
  	changeInputValue(event){
		this.message = event.target.value;
	},
	geStates(){
		this.states = ['paraná', 'são paulo']
	}
  },
  created(){
  	console.log('true')

  }

})