/*     */ package mzm.gsp.drawcarnival;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.LinkedList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SDrawRsp
/*     */   extends __SDrawRsp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12630018;
/*     */   public int pass_type_id;
/*     */   public int pass_count;
/*     */   public byte is_use_yuan_bao;
/*     */   public FreePassInfo free_pass_info;
/*     */   public LinkedList<PassAwardInfo> pass_award_info_list;
/*     */   public int cost_yuan_bao_count;
/*     */   public int add_point_count;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12630018;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SDrawRsp()
/*     */   {
/*  39 */     this.free_pass_info = new FreePassInfo();
/*  40 */     this.pass_award_info_list = new LinkedList();
/*     */   }
/*     */   
/*     */   public SDrawRsp(int _pass_type_id_, int _pass_count_, byte _is_use_yuan_bao_, FreePassInfo _free_pass_info_, LinkedList<PassAwardInfo> _pass_award_info_list_, int _cost_yuan_bao_count_, int _add_point_count_) {
/*  44 */     this.pass_type_id = _pass_type_id_;
/*  45 */     this.pass_count = _pass_count_;
/*  46 */     this.is_use_yuan_bao = _is_use_yuan_bao_;
/*  47 */     this.free_pass_info = _free_pass_info_;
/*  48 */     this.pass_award_info_list = _pass_award_info_list_;
/*  49 */     this.cost_yuan_bao_count = _cost_yuan_bao_count_;
/*  50 */     this.add_point_count = _add_point_count_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     if (!this.free_pass_info._validator_()) return false;
/*  55 */     for (PassAwardInfo _v_ : this.pass_award_info_list)
/*  56 */       if (!_v_._validator_()) return false;
/*  57 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  61 */     _os_.marshal(this.pass_type_id);
/*  62 */     _os_.marshal(this.pass_count);
/*  63 */     _os_.marshal(this.is_use_yuan_bao);
/*  64 */     _os_.marshal(this.free_pass_info);
/*  65 */     _os_.compact_uint32(this.pass_award_info_list.size());
/*  66 */     for (PassAwardInfo _v_ : this.pass_award_info_list) {
/*  67 */       _os_.marshal(_v_);
/*     */     }
/*  69 */     _os_.marshal(this.cost_yuan_bao_count);
/*  70 */     _os_.marshal(this.add_point_count);
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  75 */     this.pass_type_id = _os_.unmarshal_int();
/*  76 */     this.pass_count = _os_.unmarshal_int();
/*  77 */     this.is_use_yuan_bao = _os_.unmarshal_byte();
/*  78 */     this.free_pass_info.unmarshal(_os_);
/*  79 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  80 */       PassAwardInfo _v_ = new PassAwardInfo();
/*  81 */       _v_.unmarshal(_os_);
/*  82 */       this.pass_award_info_list.add(_v_);
/*     */     }
/*  84 */     this.cost_yuan_bao_count = _os_.unmarshal_int();
/*  85 */     this.add_point_count = _os_.unmarshal_int();
/*  86 */     if (!_validator_()) {
/*  87 */       throw new VerifyError("validator failed");
/*     */     }
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  93 */     if (_o1_ == this) return true;
/*  94 */     if ((_o1_ instanceof SDrawRsp)) {
/*  95 */       SDrawRsp _o_ = (SDrawRsp)_o1_;
/*  96 */       if (this.pass_type_id != _o_.pass_type_id) return false;
/*  97 */       if (this.pass_count != _o_.pass_count) return false;
/*  98 */       if (this.is_use_yuan_bao != _o_.is_use_yuan_bao) return false;
/*  99 */       if (!this.free_pass_info.equals(_o_.free_pass_info)) return false;
/* 100 */       if (!this.pass_award_info_list.equals(_o_.pass_award_info_list)) return false;
/* 101 */       if (this.cost_yuan_bao_count != _o_.cost_yuan_bao_count) return false;
/* 102 */       if (this.add_point_count != _o_.add_point_count) return false;
/* 103 */       return true;
/*     */     }
/* 105 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 109 */     int _h_ = 0;
/* 110 */     _h_ += this.pass_type_id;
/* 111 */     _h_ += this.pass_count;
/* 112 */     _h_ += this.is_use_yuan_bao;
/* 113 */     _h_ += this.free_pass_info.hashCode();
/* 114 */     _h_ += this.pass_award_info_list.hashCode();
/* 115 */     _h_ += this.cost_yuan_bao_count;
/* 116 */     _h_ += this.add_point_count;
/* 117 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 121 */     StringBuilder _sb_ = new StringBuilder();
/* 122 */     _sb_.append("(");
/* 123 */     _sb_.append(this.pass_type_id).append(",");
/* 124 */     _sb_.append(this.pass_count).append(",");
/* 125 */     _sb_.append(this.is_use_yuan_bao).append(",");
/* 126 */     _sb_.append(this.free_pass_info).append(",");
/* 127 */     _sb_.append(this.pass_award_info_list).append(",");
/* 128 */     _sb_.append(this.cost_yuan_bao_count).append(",");
/* 129 */     _sb_.append(this.add_point_count).append(",");
/* 130 */     _sb_.append(")");
/* 131 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\SDrawRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */