package restaurantmanagement

type MenuItem struct {
	ID    string
	Name  string
	Price float64
}

type Menu struct {
	NumOfItems int
	Items      map[string]MenuItem
}

func (m Menu) AddItem(name string, price float64) MenuItem {
	var id string
	// id := generateID()
	menuItem := MenuItem{
		ID:    id,
		Name:  name,
		Price: price,
	}

	m.Items[id] = menuItem
	return menuItem
}

func (m Menu) DeleteItem(itemID string) bool {
	delete(m.Items, itemID)
	return true
}
