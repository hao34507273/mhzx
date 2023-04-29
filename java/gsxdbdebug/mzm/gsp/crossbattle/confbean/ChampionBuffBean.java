/*    */ package mzm.gsp.crossbattle.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class ChampionBuffBean implements Marshal
/*    */ {
/*    */   public int champion_buff;
/*    */   public int champion_buff_ratio;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.champion_buff = Integer.valueOf(rootElement.attributeValue("champion_buff")).intValue();
/* 15 */     this.champion_buff_ratio = Integer.valueOf(rootElement.attributeValue("champion_buff_ratio")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.champion_buff);
/* 21 */     _os_.marshal(this.champion_buff_ratio);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.champion_buff = _os_.unmarshal_int();
/* 28 */     this.champion_buff_ratio = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\ChampionBuffBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */