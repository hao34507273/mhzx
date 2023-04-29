/*    */ package mzm.gsp.guaji;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashSet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSyncDoublePoint
/*    */   extends __SSyncDoublePoint__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12591107;
/*    */   public int getingpoolpointnum;
/*    */   public int frozenpoolpointnum;
/*    */   public HashSet<Integer> switches;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12591107;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSyncDoublePoint()
/*    */   {
/* 35 */     this.switches = new HashSet();
/*    */   }
/*    */   
/*    */   public SSyncDoublePoint(int _getingpoolpointnum_, int _frozenpoolpointnum_, HashSet<Integer> _switches_) {
/* 39 */     this.getingpoolpointnum = _getingpoolpointnum_;
/* 40 */     this.frozenpoolpointnum = _frozenpoolpointnum_;
/* 41 */     this.switches = _switches_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.getingpoolpointnum);
/* 50 */     _os_.marshal(this.frozenpoolpointnum);
/* 51 */     _os_.compact_uint32(this.switches.size());
/* 52 */     for (Integer _v_ : this.switches) {
/* 53 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.getingpoolpointnum = _os_.unmarshal_int();
/* 60 */     this.frozenpoolpointnum = _os_.unmarshal_int();
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 63 */       int _v_ = _os_.unmarshal_int();
/* 64 */       this.switches.add(Integer.valueOf(_v_));
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SSyncDoublePoint)) {
/* 75 */       SSyncDoublePoint _o_ = (SSyncDoublePoint)_o1_;
/* 76 */       if (this.getingpoolpointnum != _o_.getingpoolpointnum) return false;
/* 77 */       if (this.frozenpoolpointnum != _o_.frozenpoolpointnum) return false;
/* 78 */       if (!this.switches.equals(_o_.switches)) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.getingpoolpointnum;
/* 87 */     _h_ += this.frozenpoolpointnum;
/* 88 */     _h_ += this.switches.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.getingpoolpointnum).append(",");
/* 96 */     _sb_.append(this.frozenpoolpointnum).append(",");
/* 97 */     _sb_.append(this.switches).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guaji\SSyncDoublePoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */