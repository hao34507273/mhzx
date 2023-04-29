/*    */ package mzm.gsp.crossbattle.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SelectionMatchBean implements Marshal
/*    */ {
/*    */   public int corps_a_rank;
/*    */   public int corps_b_rank;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.corps_a_rank = Integer.valueOf(rootElement.attributeValue("corps_a_rank")).intValue();
/* 15 */     this.corps_b_rank = Integer.valueOf(rootElement.attributeValue("corps_b_rank")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.corps_a_rank);
/* 21 */     _os_.marshal(this.corps_b_rank);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.corps_a_rank = _os_.unmarshal_int();
/* 28 */     this.corps_b_rank = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\SelectionMatchBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */