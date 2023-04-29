/*    */ package mzm.gsp.planttree.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SSectionInfo implements Marshal
/*    */ {
/*    */   public int section_total_point;
/*    */   public int section_complete_award_id;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.section_total_point = Integer.valueOf(rootElement.attributeValue("section_total_point")).intValue();
/* 15 */     this.section_complete_award_id = Integer.valueOf(rootElement.attributeValue("section_complete_award_id")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.section_total_point);
/* 21 */     _os_.marshal(this.section_complete_award_id);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.section_total_point = _os_.unmarshal_int();
/* 28 */     this.section_complete_award_id = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\confbean\SSectionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */