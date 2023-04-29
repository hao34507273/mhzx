/*    */ package mzm.gsp.memorycompetition;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class QuestionInfo implements Marshal
/*    */ {
/*    */   public int question_id;
/*    */   public ArrayList<Integer> option_list;
/*    */   
/*    */   public QuestionInfo()
/*    */   {
/* 15 */     this.option_list = new ArrayList();
/*    */   }
/*    */   
/*    */   public QuestionInfo(int _question_id_, ArrayList<Integer> _option_list_) {
/* 19 */     this.question_id = _question_id_;
/* 20 */     this.option_list = _option_list_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.question_id);
/* 29 */     _os_.compact_uint32(this.option_list.size());
/* 30 */     for (Integer _v_ : this.option_list) {
/* 31 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     this.question_id = _os_.unmarshal_int();
/* 38 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 40 */       int _v_ = _os_.unmarshal_int();
/* 41 */       this.option_list.add(Integer.valueOf(_v_));
/*    */     }
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof QuestionInfo)) {
/* 49 */       QuestionInfo _o_ = (QuestionInfo)_o1_;
/* 50 */       if (this.question_id != _o_.question_id) return false;
/* 51 */       if (!this.option_list.equals(_o_.option_list)) return false;
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 58 */     int _h_ = 0;
/* 59 */     _h_ += this.question_id;
/* 60 */     _h_ += this.option_list.hashCode();
/* 61 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 65 */     StringBuilder _sb_ = new StringBuilder();
/* 66 */     _sb_.append("(");
/* 67 */     _sb_.append(this.question_id).append(",");
/* 68 */     _sb_.append(this.option_list).append(",");
/* 69 */     _sb_.append(")");
/* 70 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\QuestionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */