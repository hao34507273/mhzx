/*    */ package mzm.gsp.activity;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class STmpActivityNormalResult
/*    */   extends __STmpActivityNormalResult__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587596;
/*    */   public static final int JOIN_ACTIVITY_ERROR__ALREADY_DONE = 1;
/*    */   public static final int JOIN_ACTIVITY_ERROR__NOT_NEAR_NPC = 2;
/*    */   public static final int JOIN_ACTIVITY_ERROR__ALREADY_ACCEPT = 3;
/*    */   public static final int JOIN_ACTIVITY_ERROR__BAN = 4;
/*    */   public static final int JOIN_ACTIVITY_ERROR__OPEN_CLOSE = 5;
/*    */   public int result;
/*    */   public ArrayList<String> args;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12587596;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public STmpActivityNormalResult()
/*    */   {
/* 40 */     this.args = new ArrayList();
/*    */   }
/*    */   
/*    */   public STmpActivityNormalResult(int _result_, ArrayList<String> _args_) {
/* 44 */     this.result = _result_;
/* 45 */     this.args = _args_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 49 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 53 */     _os_.marshal(this.result);
/* 54 */     _os_.compact_uint32(this.args.size());
/* 55 */     for (String _v_ : this.args) {
/* 56 */       _os_.marshal(_v_, "UTF-16LE");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 62 */     this.result = _os_.unmarshal_int();
/* 63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 65 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 66 */       this.args.add(_v_);
/*    */     }
/* 68 */     if (!_validator_()) {
/* 69 */       throw new VerifyError("validator failed");
/*    */     }
/* 71 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 75 */     if (_o1_ == this) return true;
/* 76 */     if ((_o1_ instanceof STmpActivityNormalResult)) {
/* 77 */       STmpActivityNormalResult _o_ = (STmpActivityNormalResult)_o1_;
/* 78 */       if (this.result != _o_.result) return false;
/* 79 */       if (!this.args.equals(_o_.args)) return false;
/* 80 */       return true;
/*    */     }
/* 82 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 86 */     int _h_ = 0;
/* 87 */     _h_ += this.result;
/* 88 */     _h_ += this.args.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.result).append(",");
/* 96 */     _sb_.append(this.args).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\STmpActivityNormalResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */