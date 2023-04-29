/*    */ package mzm.gsp.homeland.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class ProbabilityInfo implements Marshal
/*    */ {
/*    */   public int mystery_visitor_cfg_id;
/*    */   public int probability;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.mystery_visitor_cfg_id = Integer.valueOf(rootElement.attributeValue("mystery_visitor_cfg_id")).intValue();
/* 15 */     this.probability = Integer.valueOf(rootElement.attributeValue("probability")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.mystery_visitor_cfg_id);
/* 21 */     _os_.marshal(this.probability);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.mystery_visitor_cfg_id = _os_.unmarshal_int();
/* 28 */     this.probability = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\confbean\ProbabilityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */