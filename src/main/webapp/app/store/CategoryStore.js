/**
 * Created by Administrator on 14-8-20.
 */

Ext.define('ShopDemo.store.CategoryStore', {
    extend: 'Ext.data.Store',

    requires: [
        'ShopDemo.model.Category',
        'Ext.data.proxy.Ajax',
        'Ext.data.reader.Json'
    ],

    config: {
        autoLoad: true,
        autoDestroy: true,
        model: 'ShopDemo.model.Category',
        storeId: 'CategoryStore',
        proxy: {
            type: 'ajax',
            url: '/category',
            reader: {
                type: 'json'
            }
        }
    }
});