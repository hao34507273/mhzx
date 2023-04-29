/*    */ package mzm.gsp.crossbattle.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class ChampionItemBean implements Marshal
/*    */ {
/*    */   public int champion_item;
/*    */   public int champion_item_num;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.champion_item = Integer.valueOf(rootElement.attributeValue("champion_item")).intValue();
/* 15 */     this.champion_item_num = Integer.valueOf(rootElement.attributeValue("champion_item_num")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.champion_item);
/* 21 */     _os_.marshal(this.champion_item_num);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.champion_item = _os_.unmarshal_int();
/* 28 */     this.champion_item_num = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\ChampionItemBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */