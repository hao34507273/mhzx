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
/*    */ 
/*    */ 
/*    */ public class SNotifyJailDeliveryBegin
/*    */   extends __SNotifyJailDeliveryBegin__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12620042;
/*    */   public ArrayList<Octets> namelist;
/*    */   public Octets name;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12620042;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SNotifyJailDeliveryBegin()
/*    */   {
/* 34 */     this.namelist = new ArrayList();
/* 35 */     this.name = new Octets();
/*    */   }
/*    */   
/*    */   public SNotifyJailDeliveryBegin(ArrayList<Octets> _namelist_, Octets _name_) {
/* 39 */     this.namelist = _namelist_;
/* 40 */     this.name = _name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.compact_uint32(this.namelist.size());
/* 49 */     for (Octets _v_ : this.namelist) {
/* 50 */       _os_.marshal(_v_);
/*    */     }
/* 52 */     _os_.marshal(this.name);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 59 */       Octets _v_ = _os_.unmarshal_Octets();
/* 60 */       this.namelist.add(_v_);
/*    */     }
/* 62 */     this.name = _os_.unmarshal_Octets();
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof SNotifyJailDeliveryBegin)) {
/* 72 */       SNotifyJailDeliveryBegin _o_ = (SNotifyJailDeliveryBegin)_o1_;
/* 73 */       if (!this.namelist.equals(_o_.namelist)) return false;
/* 74 */       if (!this.name.equals(_o_.name)) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.namelist.hashCode();
/* 83 */     _h_ += this.name.hashCode();
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.namelist).append(",");
/* 91 */     _sb_.append("B").append(this.name.size()).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\SNotifyJailDeliveryBegin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */