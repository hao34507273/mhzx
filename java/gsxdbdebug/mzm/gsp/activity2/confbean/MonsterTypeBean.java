/*    */ package mzm.gsp.activity2.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import org.dom4j.Element;
/*    */ import util.XmlHelper;
/*    */ 
/*    */ public class MonsterTypeBean implements Marshal
/*    */ {
/*    */   public int monster_kill_award_id;
/*    */   public int monster_kill_award_num;
/*    */   public int next_controller_need_kill_num;
/*    */   public String bornNotice;
/*    */   public String deadNotice;
/* 18 */   public ArrayList<Integer> monster_category_id_list = new ArrayList();
/* 19 */   public ArrayList<ControllerIdBean> controller_id_list = new ArrayList();
/*    */   
/*    */   public void loadFromXml(Element rootElement) {
/* 22 */     Element collectionElement = XmlHelper.getVariableElement(rootElement, "monster_category_id_list");
/* 23 */     if (collectionElement == null) {
/* 24 */       throw new RuntimeException("collection type element does not find");
/*    */     }
/* 26 */     List<?> _nodeList = collectionElement.elements();
/* 27 */     int _len = _nodeList.size();
/* 28 */     for (int i = 0; i < _len; i++) {
/* 29 */       Element elem = (Element)_nodeList.get(i);
/* 30 */       if (elem.getName().equalsIgnoreCase("int")) {
/*    */         try {
/* 32 */           this.monster_category_id_list.add(Integer.valueOf(Integer.valueOf(elem.getText()).intValue()));
/*    */         }
/*    */         catch (Exception e) {}
/*    */       }
/*    */     }
/* 37 */     this.monster_kill_award_id = Integer.valueOf(rootElement.attributeValue("monster_kill_award_id")).intValue();
/* 38 */     this.monster_kill_award_num = Integer.valueOf(rootElement.attributeValue("monster_kill_award_num")).intValue();
/* 39 */     this.next_controller_need_kill_num = Integer.valueOf(rootElement.attributeValue("next_controller_need_kill_num")).intValue();
/* 40 */     this.bornNotice = rootElement.attributeValue("bornNotice");
/* 41 */     this.deadNotice = rootElement.attributeValue("deadNotice");
/* 42 */     Element collectionElement2 = XmlHelper.getVariableElement(rootElement, "controller_id_list");
/* 43 */     if (collectionElement2 == null) {
/* 44 */       throw new RuntimeException("collection type element does not find");
/*    */     }
/* 46 */     List<?> _nodeList2 = collectionElement2.elements();
/* 47 */     int _len2 = _nodeList2.size();
/* 48 */     for (int i2 = 0; i2 < _len2; i2++) {
/* 49 */       Element elem2 = (Element)_nodeList2.get(i2);
/* 50 */       if (elem2.getName().equalsIgnoreCase("mzm.gsp.activity2.confbean.ControllerIdBean")) {
/*    */         try {
/* 52 */           ControllerIdBean _v_ = new ControllerIdBean();
/* 53 */           _v_.loadFromXml(elem2);
/* 54 */           this.controller_id_list.add(_v_);
/*    */         }
/*    */         catch (Exception e2) {}
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 62 */     _os_.compact_uint32(this.monster_category_id_list.size());
/* 63 */     Iterator<Integer> i$ = this.monster_category_id_list.iterator();
/* 64 */     while (i$.hasNext()) {
/* 65 */       Integer _v_ = (Integer)i$.next();
/* 66 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 68 */     _os_.marshal(this.monster_kill_award_id);
/* 69 */     _os_.marshal(this.monster_kill_award_num);
/* 70 */     _os_.marshal(this.next_controller_need_kill_num);
/* 71 */     _os_.marshal(this.bornNotice, "UTF-8");
/* 72 */     _os_.marshal(this.deadNotice, "UTF-8");
/* 73 */     _os_.compact_uint32(this.controller_id_list.size());
/* 74 */     Iterator<ControllerIdBean> i$2 = this.controller_id_list.iterator();
/* 75 */     while (i$2.hasNext()) {
/* 76 */       ControllerIdBean _v_2 = (ControllerIdBean)i$2.next();
/* 77 */       _os_.marshal(_v_2);
/*    */     }
/* 79 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 83 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 84 */       this.monster_category_id_list.add(Integer.valueOf(_os_.unmarshal_int()));
/*    */     }
/* 86 */     this.monster_kill_award_id = _os_.unmarshal_int();
/* 87 */     this.monster_kill_award_num = _os_.unmarshal_int();
/* 88 */     this.next_controller_need_kill_num = _os_.unmarshal_int();
/* 89 */     this.bornNotice = _os_.unmarshal_String("UTF-8");
/* 90 */     this.deadNotice = _os_.unmarshal_String("UTF-8");
/* 91 */     for (int _size_2 = _os_.uncompact_uint32(); _size_2 > 0; _size_2--) {
/* 92 */       ControllerIdBean _v_ = new ControllerIdBean();
/* 93 */       _v_.unmarshal(_os_);
/* 94 */       this.controller_id_list.add(_v_);
/*    */     }
/* 96 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity2\confbean\MonsterTypeBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */