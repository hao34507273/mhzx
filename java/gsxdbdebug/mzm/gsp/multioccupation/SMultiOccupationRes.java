/*    */ package mzm.gsp.multioccupation;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.LinkedList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SMultiOccupationRes
/*    */   extends __SMultiOccupationRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12606978;
/*    */   public LinkedList<Integer> activated_occpations;
/*    */   public long activate_time;
/*    */   public long switch_time;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12606978;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SMultiOccupationRes()
/*    */   {
/* 35 */     this.activated_occpations = new LinkedList();
/*    */   }
/*    */   
/*    */   public SMultiOccupationRes(LinkedList<Integer> _activated_occpations_, long _activate_time_, long _switch_time_) {
/* 39 */     this.activated_occpations = _activated_occpations_;
/* 40 */     this.activate_time = _activate_time_;
/* 41 */     this.switch_time = _switch_time_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.compact_uint32(this.activated_occpations.size());
/* 50 */     for (Integer _v_ : this.activated_occpations) {
/* 51 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 53 */     _os_.marshal(this.activate_time);
/* 54 */     _os_.marshal(this.switch_time);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 61 */       int _v_ = _os_.unmarshal_int();
/* 62 */       this.activated_occpations.add(Integer.valueOf(_v_));
/*    */     }
/* 64 */     this.activate_time = _os_.unmarshal_long();
/* 65 */     this.switch_time = _os_.unmarshal_long();
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SMultiOccupationRes)) {
/* 75 */       SMultiOccupationRes _o_ = (SMultiOccupationRes)_o1_;
/* 76 */       if (!this.activated_occpations.equals(_o_.activated_occpations)) return false;
/* 77 */       if (this.activate_time != _o_.activate_time) return false;
/* 78 */       if (this.switch_time != _o_.switch_time) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.activated_occpations.hashCode();
/* 87 */     _h_ += (int)this.activate_time;
/* 88 */     _h_ += (int)this.switch_time;
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.activated_occpations).append(",");
/* 96 */     _sb_.append(this.activate_time).append(",");
/* 97 */     _sb_.append(this.switch_time).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\multioccupation\SMultiOccupationRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */