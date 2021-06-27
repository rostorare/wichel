export default {
  props: ['title'],
  template: `
    <div>
      <input v-model="nameField" placeholder="Name" type="text" ref="nameInput">
      <input v-model="mailField" placeholder="Mail" @keyup.enter="save()">
      <button type="button" @click="save()">Save</button>
    </div>
    <div>
      <h3> {{ title }} </h3>
        <table>
          <thead>
          <tr>
            <th>Name</th>
            <th>Mail</th>
          </tr>
          </thead>
          <tbody>
          <tr v-if="items.length === 0">
            <td colspan="2">No persons yet</td>
          </tr>
          <tr v-for="person in items">
            <td>{{person.name}}</td>
            <td>{{person.mail}}</td>
          </tr>
          <tr>
            <td>{{ nameField }}</td>
            <td>{{ mailField }}</td>
          </tr>
          </tbody>
        </table>
    </div>
  `,
  data() {
    return {
      items: [],
      nameField: '',
      mailField: '',
    };
  },
  methods: {
    loadPersons() {
      axios
        .get('/persons')
        .then(response => (this.items = response.data))
    },
    save() {
      axios
        .post('/persons', {
          name: this.nameField,
          mail: this.mailField
        })
        .then((response) => {
          this.nameField = '';
          this.mailField = '';
          this.$refs.nameInput.focus();
          this.loadPersons();
        }, (error) => {
          console.log('Could not save person!');
        });
    },
  },
  mounted: function() {
    this.loadPersons();
  }
}