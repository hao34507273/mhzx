/*    */ package mzm.gsp.memorycompetition;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class QuestionIdList implements Marshal
/*    */ {
/*    */   public ArrayList<Integer> quesition_id_list;
/*    */   
/*    */   public QuestionIdList()
/*    */   {
/* 14 */     this.quesition_id_list = new ArrayList();
/*    */   }
/*    */   
/*    */   public QuestionIdList(ArrayList<Integer> _quesition_id_list_) {
/* 18 */     this.quesition_id_list = _quesition_id_list_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     _os_.compact_uint32(this.quesition_id_list.size());
/* 27 */     for (Integer _v_ : this.quesition_id_list) {
/* 28 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 34 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 36 */       int _v_ = _os_.unmarshal_int();
/* 37 */       this.quesition_id_list.add(Integer.valueOf(_v_));
/*    */     }
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof QuestionIdList)) {
/* 45 */       QuestionIdList _o_ = (QuestionIdList)_o1_;
/* 46 */       if (!this.quesition_id_list.equals(_o_.quesition_id_list)) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.quesition_id_list.hashCode();
/* 55 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 59 */     StringBuilder _sb_ = new StringBuilder();
/* 60 */     _sb_.append("(");
/* 61 */     _sb_.append(this.quesition_id_list).append(",");
/* 62 */     _sb_.append(")");
/* 63 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\QuestionIdList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */