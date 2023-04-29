/*    */ package mzm.gsp.xiaohuikuaipao;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SPointExchangeInfoRsp
/*    */   extends __SPointExchangeInfoRsp__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12622860;
/*    */   public long pointcount;
/*    */   public HashMap<Integer, Integer> cfgid2available;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12622860;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SPointExchangeInfoRsp()
/*    */   {
/* 32 */     this.cfgid2available = new HashMap();
/*    */   }
/*    */   
/*    */   public SPointExchangeInfoRsp(long _pointcount_, HashMap<Integer, Integer> _cfgid2available_) {
/* 36 */     this.pointcount = _pointcount_;
/* 37 */     this.cfgid2available = _cfgid2available_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.pointcount);
/* 46 */     _os_.compact_uint32(this.cfgid2available.size());
/* 47 */     for (Map.Entry<Integer, Integer> _e_ : this.cfgid2available.entrySet()) {
/* 48 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 49 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.pointcount = _os_.unmarshal_long();
/* 56 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 58 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 60 */       int _v_ = _os_.unmarshal_int();
/* 61 */       this.cfgid2available.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof SPointExchangeInfoRsp)) {
/* 72 */       SPointExchangeInfoRsp _o_ = (SPointExchangeInfoRsp)_o1_;
/* 73 */       if (this.pointcount != _o_.pointcount) return false;
/* 74 */       if (!this.cfgid2available.equals(_o_.cfgid2available)) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += (int)this.pointcount;
/* 83 */     _h_ += this.cfgid2available.hashCode();
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.pointcount).append(",");
/* 91 */     _sb_.append(this.cfgid2available).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\SPointExchangeInfoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */