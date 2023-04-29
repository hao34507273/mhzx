/*    */ package mzm.gsp.prison;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SNotifyJailBreakResult
/*    */   extends __SNotifyJailBreakResult__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12620033;
/*    */   public static final int SUCCESS = 1;
/*    */   public static final int FAIL = 2;
/*    */   public int result;
/*    */   public ArrayList<Octets> namelist;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12620033;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SNotifyJailBreakResult()
/*    */   {
/* 37 */     this.namelist = new ArrayList();
/*    */   }
/*    */   
/*    */   public SNotifyJailBreakResult(int _result_, ArrayList<Octets> _namelist_) {
/* 41 */     this.result = _result_;
/* 42 */     this.namelist = _namelist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.result);
/* 51 */     _os_.compact_uint32(this.namelist.size());
/* 52 */     for (Octets _v_ : this.namelist) {
/* 53 */       _os_.marshal(_v_);
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.result = _os_.unmarshal_int();
/* 60 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 62 */       Octets _v_ = _os_.unmarshal_Octets();
/* 63 */       this.namelist.add(_v_);
/*    */     }
/* 65 */     if (!_validator_()) {
/* 66 */       throw new VerifyError("validator failed");
/*    */     }
/* 68 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 72 */     if (_o1_ == this) return true;
/* 73 */     if ((_o1_ instanceof SNotifyJailBreakResult)) {
/* 74 */       SNotifyJailBreakResult _o_ = (SNotifyJailBreakResult)_o1_;
/* 75 */       if (this.result != _o_.result) return false;
/* 76 */       if (!this.namelist.equals(_o_.namelist)) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.result;
/* 85 */     _h_ += this.namelist.hashCode();
/* 86 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 90 */     StringBuilder _sb_ = new StringBuilder();
/* 91 */     _sb_.append("(");
/* 92 */     _sb_.append(this.result).append(",");
/* 93 */     _sb_.append(this.namelist).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\SNotifyJailBreakResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */