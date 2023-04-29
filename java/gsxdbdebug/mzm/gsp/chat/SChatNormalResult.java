/*    */ package mzm.gsp.chat;
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
/*    */ public class SChatNormalResult
/*    */   extends __SChatNormalResult__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585239;
/*    */   public static final int CUT_VIGOR_SUC = 1;
/*    */   public static final int CHECK_PACKETINFO_ERROR__NO_ITEM = 10;
/*    */   public static final int CHECK_PACKETINFO_ERROR__NO_PET = 11;
/*    */   public static final int CHECK_PACKETINFO_ERROR__NO_MOUNTS = 12;
/*    */   public int result;
/*    */   public ArrayList<String> args;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12585239;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SChatNormalResult()
/*    */   {
/* 39 */     this.args = new ArrayList();
/*    */   }
/*    */   
/*    */   public SChatNormalResult(int _result_, ArrayList<String> _args_) {
/* 43 */     this.result = _result_;
/* 44 */     this.args = _args_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 48 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 52 */     _os_.marshal(this.result);
/* 53 */     _os_.compact_uint32(this.args.size());
/* 54 */     for (String _v_ : this.args) {
/* 55 */       _os_.marshal(_v_, "UTF-16LE");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 61 */     this.result = _os_.unmarshal_int();
/* 62 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 64 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 65 */       this.args.add(_v_);
/*    */     }
/* 67 */     if (!_validator_()) {
/* 68 */       throw new VerifyError("validator failed");
/*    */     }
/* 70 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 74 */     if (_o1_ == this) return true;
/* 75 */     if ((_o1_ instanceof SChatNormalResult)) {
/* 76 */       SChatNormalResult _o_ = (SChatNormalResult)_o1_;
/* 77 */       if (this.result != _o_.result) return false;
/* 78 */       if (!this.args.equals(_o_.args)) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.result;
/* 87 */     _h_ += this.args.hashCode();
/* 88 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 92 */     StringBuilder _sb_ = new StringBuilder();
/* 93 */     _sb_.append("(");
/* 94 */     _sb_.append(this.result).append(",");
/* 95 */     _sb_.append(this.args).append(",");
/* 96 */     _sb_.append(")");
/* 97 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\SChatNormalResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */