/*    */ package mzm.gsp.crossbattle.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class RankAwardBuffBean implements Marshal
/*    */ {
/*    */   public int buff_id;
/*    */   public int buff_ratio;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.buff_id = Integer.valueOf(rootElement.attributeValue("buff_id")).intValue();
/* 15 */     this.buff_ratio = Integer.valueOf(rootElement.attributeValue("buff_ratio")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.buff_id);
/* 21 */     _os_.marshal(this.buff_ratio);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.buff_id = _os_.unmarshal_int();
/* 28 */     this.buff_ratio = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\RankAwardBuffBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */