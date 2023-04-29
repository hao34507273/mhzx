/*    */ package mzm.gsp.mail;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class FormatArgs implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public ArrayList<String> args;
/*    */   
/*    */   public FormatArgs()
/*    */   {
/* 12 */     this.args = new ArrayList();
/*    */   }
/*    */   
/*    */   public FormatArgs(ArrayList<String> _args_) {
/* 16 */     this.args = _args_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 20 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 24 */     _os_.compact_uint32(this.args.size());
/* 25 */     for (String _v_ : this.args) {
/* 26 */       _os_.marshal(_v_, "UTF-16LE");
/*    */     }
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 32 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 34 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 35 */       this.args.add(_v_);
/*    */     }
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof FormatArgs)) {
/* 43 */       FormatArgs _o_ = (FormatArgs)_o1_;
/* 44 */       if (!this.args.equals(_o_.args)) return false;
/* 45 */       return true;
/*    */     }
/* 47 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 51 */     int _h_ = 0;
/* 52 */     _h_ += this.args.hashCode();
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.args).append(",");
/* 60 */     _sb_.append(")");
/* 61 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mail\FormatArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */