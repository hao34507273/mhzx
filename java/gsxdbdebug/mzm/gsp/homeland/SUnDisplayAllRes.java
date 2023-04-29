/*    */ package mzm.gsp.homeland;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
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
/*    */ public class SUnDisplayAllRes
/*    */   extends __SUnDisplayAllRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605469;
/*    */   public int decfengshui;
/*    */   public HashMap<Integer, FurnitureUuIds> undisplayfurnitures;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12605469;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SUnDisplayAllRes()
/*    */   {
/* 32 */     this.undisplayfurnitures = new HashMap();
/*    */   }
/*    */   
/*    */   public SUnDisplayAllRes(int _decfengshui_, HashMap<Integer, FurnitureUuIds> _undisplayfurnitures_) {
/* 36 */     this.decfengshui = _decfengshui_;
/* 37 */     this.undisplayfurnitures = _undisplayfurnitures_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     for (Map.Entry<Integer, FurnitureUuIds> _e_ : this.undisplayfurnitures.entrySet()) {
/* 42 */       if (!((FurnitureUuIds)_e_.getValue())._validator_()) return false;
/*    */     }
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.decfengshui);
/* 49 */     _os_.compact_uint32(this.undisplayfurnitures.size());
/* 50 */     for (Map.Entry<Integer, FurnitureUuIds> _e_ : this.undisplayfurnitures.entrySet()) {
/* 51 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 52 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.decfengshui = _os_.unmarshal_int();
/* 59 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 61 */       int _k_ = _os_.unmarshal_int();
/* 62 */       FurnitureUuIds _v_ = new FurnitureUuIds();
/* 63 */       _v_.unmarshal(_os_);
/* 64 */       this.undisplayfurnitures.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SUnDisplayAllRes)) {
/* 75 */       SUnDisplayAllRes _o_ = (SUnDisplayAllRes)_o1_;
/* 76 */       if (this.decfengshui != _o_.decfengshui) return false;
/* 77 */       if (!this.undisplayfurnitures.equals(_o_.undisplayfurnitures)) return false;
/* 78 */       return true;
/*    */     }
/* 80 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 84 */     int _h_ = 0;
/* 85 */     _h_ += this.decfengshui;
/* 86 */     _h_ += this.undisplayfurnitures.hashCode();
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.decfengshui).append(",");
/* 94 */     _sb_.append(this.undisplayfurnitures).append(",");
/* 95 */     _sb_.append(")");
/* 96 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\SUnDisplayAllRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */