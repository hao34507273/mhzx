/*    */ package mzm.gsp.question;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class PictureQuestionInfo implements Marshal
/*    */ {
/*    */   public static final int RESOURCE_TYPE = 0;
/*    */   public int questionitemid;
/*    */   public HashMap<Integer, String> parammap;
/*    */   public ArrayList<Integer> answerlist;
/*    */   
/*    */   public PictureQuestionInfo()
/*    */   {
/* 18 */     this.parammap = new HashMap();
/* 19 */     this.answerlist = new ArrayList();
/*    */   }
/*    */   
/*    */   public PictureQuestionInfo(int _questionitemid_, HashMap<Integer, String> _parammap_, ArrayList<Integer> _answerlist_) {
/* 23 */     this.questionitemid = _questionitemid_;
/* 24 */     this.parammap = _parammap_;
/* 25 */     this.answerlist = _answerlist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.questionitemid);
/* 34 */     _os_.compact_uint32(this.parammap.size());
/* 35 */     for (Map.Entry<Integer, String> _e_ : this.parammap.entrySet()) {
/* 36 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 37 */       _os_.marshal((String)_e_.getValue(), "UTF-16LE");
/*    */     }
/* 39 */     _os_.compact_uint32(this.answerlist.size());
/* 40 */     for (Integer _v_ : this.answerlist) {
/* 41 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 47 */     this.questionitemid = _os_.unmarshal_int();
/* 48 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 50 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 52 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 53 */       this.parammap.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 55 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 57 */       int _v_ = _os_.unmarshal_int();
/* 58 */       this.answerlist.add(Integer.valueOf(_v_));
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof PictureQuestionInfo)) {
/* 66 */       PictureQuestionInfo _o_ = (PictureQuestionInfo)_o1_;
/* 67 */       if (this.questionitemid != _o_.questionitemid) return false;
/* 68 */       if (!this.parammap.equals(_o_.parammap)) return false;
/* 69 */       if (!this.answerlist.equals(_o_.answerlist)) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.questionitemid;
/* 78 */     _h_ += this.parammap.hashCode();
/* 79 */     _h_ += this.answerlist.hashCode();
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.questionitemid).append(",");
/* 87 */     _sb_.append(this.parammap).append(",");
/* 88 */     _sb_.append(this.answerlist).append(",");
/* 89 */     _sb_.append(")");
/* 90 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\PictureQuestionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */