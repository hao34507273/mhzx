/*    */ package mzm.gsp.drawandguess;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSynDrawLineInfoList
/*    */   extends __SSynDrawLineInfoList__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617251;
/*    */   public ArrayList<DrawLineInfo> drawlineinfo_list;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12617251;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSynDrawLineInfoList()
/*    */   {
/* 33 */     this.drawlineinfo_list = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSynDrawLineInfoList(ArrayList<DrawLineInfo> _drawlineinfo_list_) {
/* 37 */     this.drawlineinfo_list = _drawlineinfo_list_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     for (DrawLineInfo _v_ : this.drawlineinfo_list)
/* 42 */       if (!_v_._validator_()) return false;
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.compact_uint32(this.drawlineinfo_list.size());
/* 48 */     for (DrawLineInfo _v_ : this.drawlineinfo_list) {
/* 49 */       _os_.marshal(_v_);
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 56 */       DrawLineInfo _v_ = new DrawLineInfo();
/* 57 */       _v_.unmarshal(_os_);
/* 58 */       this.drawlineinfo_list.add(_v_);
/*    */     }
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SSynDrawLineInfoList)) {
/* 69 */       SSynDrawLineInfoList _o_ = (SSynDrawLineInfoList)_o1_;
/* 70 */       if (!this.drawlineinfo_list.equals(_o_.drawlineinfo_list)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.drawlineinfo_list.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.drawlineinfo_list).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\SSynDrawLineInfoList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */