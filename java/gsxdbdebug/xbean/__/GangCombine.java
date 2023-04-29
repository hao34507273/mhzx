/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.XBean;
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class GangCombine extends XBean implements xbean.GangCombine
/*     */ {
/*     */   private long gangid;
/*     */   private SetX<Long> applicants;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.gangid = 0L;
/*  21 */     this.applicants.clear();
/*     */   }
/*     */   
/*     */   GangCombine(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.applicants = new SetX();
/*     */   }
/*     */   
/*     */   public GangCombine()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public GangCombine(GangCombine _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   GangCombine(xbean.GangCombine _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof GangCombine)) { assign((GangCombine)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(GangCombine _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.gangid = _o_.gangid;
/*  53 */     this.applicants = new SetX();
/*  54 */     this.applicants.addAll(_o_.applicants);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  59 */     this.gangid = _o_.gangid;
/*  60 */     this.applicants = new SetX();
/*  61 */     this.applicants.addAll(_o_.applicants);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  67 */     _xdb_verify_unsafe_();
/*  68 */     _os_.marshal(this.gangid);
/*  69 */     _os_.compact_uint32(this.applicants.size());
/*  70 */     for (Long _v_ : this.applicants)
/*     */     {
/*  72 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     this.gangid = _os_.unmarshal_long();
/*  82 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  84 */       long _v_ = 0L;
/*  85 */       _v_ = _os_.unmarshal_long();
/*  86 */       this.applicants.add(Long.valueOf(_v_));
/*     */     }
/*  88 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  94 */     _xdb_verify_unsafe_();
/*  95 */     int _size_ = 0;
/*  96 */     _size_ += CodedOutputStream.computeInt64Size(1, this.gangid);
/*  97 */     for (Long _v_ : this.applicants)
/*     */     {
/*  99 */       _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*     */     }
/* 101 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 110 */       _output_.writeInt64(1, this.gangid);
/* 111 */       for (Long _v_ : this.applicants)
/*     */       {
/* 113 */         _output_.writeInt64(2, _v_.longValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 118 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 120 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 126 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 129 */       boolean done = false;
/* 130 */       while (!done)
/*     */       {
/* 132 */         int tag = _input_.readTag();
/* 133 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 137 */           done = true;
/* 138 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 142 */           this.gangid = _input_.readInt64();
/* 143 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 147 */           long _v_ = 0L;
/* 148 */           _v_ = _input_.readInt64();
/* 149 */           this.applicants.add(Long.valueOf(_v_));
/* 150 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 154 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 156 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 165 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 169 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 171 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GangCombine copy()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new GangCombine(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GangCombine toData()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GangCombine toBean()
/*     */   {
/* 190 */     _xdb_verify_unsafe_();
/* 191 */     return new GangCombine(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GangCombine toDataIf()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GangCombine toBeanIf()
/*     */   {
/* 203 */     _xdb_verify_unsafe_();
/* 204 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 210 */     _xdb_verify_unsafe_();
/* 211 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getGangid()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return this.gangid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Long> getApplicants()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return xdb.Logs.logSet(new xdb.LogKey(this, "applicants"), this.applicants);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> getApplicantsAsData()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/*     */     
/* 235 */     GangCombine _o_ = this;
/* 236 */     Set<Long> applicants = new SetX();
/* 237 */     applicants.addAll(_o_.applicants);
/* 238 */     return applicants;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGangid(long _v_)
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     xdb.Logs.logIf(new xdb.LogKey(this, "gangid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 250 */         new xdb.logs.LogLong(this, GangCombine.this.gangid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 254 */             GangCombine.this.gangid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 258 */     });
/* 259 */     this.gangid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 265 */     _xdb_verify_unsafe_();
/* 266 */     GangCombine _o_ = null;
/* 267 */     if ((_o1_ instanceof GangCombine)) { _o_ = (GangCombine)_o1_;
/* 268 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 269 */       return false;
/* 270 */     if (this.gangid != _o_.gangid) return false;
/* 271 */     if (!this.applicants.equals(_o_.applicants)) return false;
/* 272 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     int _h_ = 0;
/* 280 */     _h_ = (int)(_h_ + this.gangid);
/* 281 */     _h_ += this.applicants.hashCode();
/* 282 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     StringBuilder _sb_ = new StringBuilder();
/* 290 */     _sb_.append("(");
/* 291 */     _sb_.append(this.gangid);
/* 292 */     _sb_.append(",");
/* 293 */     _sb_.append(this.applicants);
/* 294 */     _sb_.append(")");
/* 295 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 301 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 302 */     lb.add(new xdb.logs.ListenableChanged().setVarName("gangid"));
/* 303 */     lb.add(new xdb.logs.ListenableSet().setVarName("applicants"));
/* 304 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.GangCombine {
/*     */     private Const() {}
/*     */     
/*     */     GangCombine nThis() {
/* 311 */       return GangCombine.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 317 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangCombine copy()
/*     */     {
/* 323 */       return GangCombine.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangCombine toData()
/*     */     {
/* 329 */       return GangCombine.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.GangCombine toBean()
/*     */     {
/* 334 */       return GangCombine.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangCombine toDataIf()
/*     */     {
/* 340 */       return GangCombine.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.GangCombine toBeanIf()
/*     */     {
/* 345 */       return GangCombine.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getGangid()
/*     */     {
/* 352 */       GangCombine.this._xdb_verify_unsafe_();
/* 353 */       return GangCombine.this.gangid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getApplicants()
/*     */     {
/* 360 */       GangCombine.this._xdb_verify_unsafe_();
/* 361 */       return xdb.Consts.constSet(GangCombine.this.applicants);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Long> getApplicantsAsData()
/*     */     {
/* 367 */       GangCombine.this._xdb_verify_unsafe_();
/*     */       
/* 369 */       GangCombine _o_ = GangCombine.this;
/* 370 */       Set<Long> applicants = new SetX();
/* 371 */       applicants.addAll(_o_.applicants);
/* 372 */       return applicants;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGangid(long _v_)
/*     */     {
/* 379 */       GangCombine.this._xdb_verify_unsafe_();
/* 380 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 386 */       GangCombine.this._xdb_verify_unsafe_();
/* 387 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 393 */       GangCombine.this._xdb_verify_unsafe_();
/* 394 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 400 */       return GangCombine.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 406 */       return GangCombine.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 412 */       GangCombine.this._xdb_verify_unsafe_();
/* 413 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 419 */       return GangCombine.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 425 */       return GangCombine.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 431 */       GangCombine.this._xdb_verify_unsafe_();
/* 432 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 438 */       return GangCombine.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 444 */       return GangCombine.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 450 */       return GangCombine.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 456 */       return GangCombine.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 462 */       return GangCombine.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 468 */       return GangCombine.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 474 */       return GangCombine.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.GangCombine
/*     */   {
/*     */     private long gangid;
/*     */     
/*     */     private HashSet<Long> applicants;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 488 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 493 */       this.applicants = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.GangCombine _o1_)
/*     */     {
/* 498 */       if ((_o1_ instanceof GangCombine)) { assign((GangCombine)_o1_);
/* 499 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 500 */       } else if ((_o1_ instanceof GangCombine.Const)) assign(((GangCombine.Const)_o1_).nThis()); else {
/* 501 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(GangCombine _o_) {
/* 506 */       this.gangid = _o_.gangid;
/* 507 */       this.applicants = new HashSet();
/* 508 */       this.applicants.addAll(_o_.applicants);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 513 */       this.gangid = _o_.gangid;
/* 514 */       this.applicants = new HashSet();
/* 515 */       this.applicants.addAll(_o_.applicants);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       _os_.marshal(this.gangid);
/* 522 */       _os_.compact_uint32(this.applicants.size());
/* 523 */       for (Long _v_ : this.applicants)
/*     */       {
/* 525 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 527 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 533 */       this.gangid = _os_.unmarshal_long();
/* 534 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 536 */         long _v_ = 0L;
/* 537 */         _v_ = _os_.unmarshal_long();
/* 538 */         this.applicants.add(Long.valueOf(_v_));
/*     */       }
/* 540 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 546 */       int _size_ = 0;
/* 547 */       _size_ += CodedOutputStream.computeInt64Size(1, this.gangid);
/* 548 */       for (Long _v_ : this.applicants)
/*     */       {
/* 550 */         _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*     */       }
/* 552 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 560 */         _output_.writeInt64(1, this.gangid);
/* 561 */         for (Long _v_ : this.applicants)
/*     */         {
/* 563 */           _output_.writeInt64(2, _v_.longValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 568 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 570 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 578 */         boolean done = false;
/* 579 */         while (!done)
/*     */         {
/* 581 */           int tag = _input_.readTag();
/* 582 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 586 */             done = true;
/* 587 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 591 */             this.gangid = _input_.readInt64();
/* 592 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 596 */             long _v_ = 0L;
/* 597 */             _v_ = _input_.readInt64();
/* 598 */             this.applicants.add(Long.valueOf(_v_));
/* 599 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 603 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 605 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 614 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 618 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 620 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangCombine copy()
/*     */     {
/* 626 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangCombine toData()
/*     */     {
/* 632 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.GangCombine toBean()
/*     */     {
/* 637 */       return new GangCombine(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangCombine toDataIf()
/*     */     {
/* 643 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.GangCombine toBeanIf()
/*     */     {
/* 648 */       return new GangCombine(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 654 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 658 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 662 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 666 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 670 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 674 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 678 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getGangid()
/*     */     {
/* 685 */       return this.gangid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getApplicants()
/*     */     {
/* 692 */       return this.applicants;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getApplicantsAsData()
/*     */     {
/* 699 */       return this.applicants;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGangid(long _v_)
/*     */     {
/* 706 */       this.gangid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 712 */       if (!(_o1_ instanceof Data)) return false;
/* 713 */       Data _o_ = (Data)_o1_;
/* 714 */       if (this.gangid != _o_.gangid) return false;
/* 715 */       if (!this.applicants.equals(_o_.applicants)) return false;
/* 716 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 722 */       int _h_ = 0;
/* 723 */       _h_ = (int)(_h_ + this.gangid);
/* 724 */       _h_ += this.applicants.hashCode();
/* 725 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 731 */       StringBuilder _sb_ = new StringBuilder();
/* 732 */       _sb_.append("(");
/* 733 */       _sb_.append(this.gangid);
/* 734 */       _sb_.append(",");
/* 735 */       _sb_.append(this.applicants);
/* 736 */       _sb_.append(")");
/* 737 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GangCombine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */