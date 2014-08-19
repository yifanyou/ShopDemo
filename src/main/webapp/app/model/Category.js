/**
 * Created by Administrator on 14-8-20.
 */
Ext.define('ShopDemo.model.Category', {
    extend: 'Ext.data.Model',

    requires: [
        'Ext.data.Field'
    ],

    config: {
        fields: [
            {
                name: 'categoryId', type: 'string'
            },
            {
                name: 'categoryName', type: 'string'
            },
            {
                name: 'childId', type: 'string'
            }
        ]
    }
});