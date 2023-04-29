/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ import xdb.logs.LogInt;
/*     */ 
/*     */ public final class Campaign extends XBean implements xbean.Campaign
/*     */ {
/*     */   private int campaign;
/*     */   private xbean.VoteAwardInfo vote_award_info;
/*     */   private int point;
/*     */   private long update_point_time;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.campaign = 0;
/*  25 */     this.vote_award_info._reset_unsafe_();
/*  26 */     this.point = 0;
/*  27 */     this.update_point_time = 0L;
/*     */   }
/*     */   
/*     */   Campaign(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.vote_award_info = new VoteAwardInfo(0, this, "vote_award_info");
/*     */   }
/*     */   
/*     */   public Campaign()
/*     */   {
/*  38 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public Campaign(Campaign _o_)
/*     */   {
/*  43 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   Campaign(xbean.Campaign _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  48 */     super(_xp_, _vn_);
/*  49 */     if ((_o1_ instanceof Campaign)) { assign((Campaign)_o1_);
/*  50 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  51 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  52 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Campaign _o_) {
/*  57 */     _o_._xdb_verify_unsafe_();
/*  58 */     this.campaign = _o_.campaign;
/*  59 */     this.vote_award_info = new VoteAwardInfo(_o_.vote_award_info, this, "vote_award_info");
/*  60 */     this.point = _o_.point;
/*  61 */     this.update_point_time = _o_.update_point_time;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  66 */     this.campaign = _o_.campaign;
/*  67 */     this.vote_award_info = new VoteAwardInfo(_o_.vote_award_info, this, "vote_award_info");
/*  68 */     this.point = _o_.point;
/*  69 */     this.update_point_time = _o_.update_point_time;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  75 */     _xdb_verify_unsafe_();
/*  76 */     _os_.marshal(this.campaign);
/*  77 */     this.vote_award_info.marshal(_os_);
/*  78 */     _os_.marshal(this.point);
/*  79 */     _os_.marshal(this.update_point_time);
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  86 */     _xdb_verify_unsafe_();
/*  87 */     this.campaign = _os_.unmarshal_int();
/*  88 */     this.vote_award_info.unmarshal(_os_);
/*  89 */     this.point = _os_.unmarshal_int();
/*  90 */     this.update_point_time = _os_.unmarshal_long();
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  97 */     _xdb_verify_unsafe_();
/*  98 */     int _size_ = 0;
/*  99 */     _size_ += CodedOutputStream.computeInt32Size(1, this.campaign);
/* 100 */     _size_ += CodedOutputStream.computeMessageSize(2, this.vote_award_info);
/* 101 */     _size_ += CodedOutputStream.computeInt32Size(3, this.point);
/* 102 */     _size_ += CodedOutputStream.computeInt64Size(4, this.update_point_time);
/* 103 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 109 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 112 */       _output_.writeInt32(1, this.campaign);
/* 113 */       _output_.writeMessage(2, this.vote_award_info);
/* 114 */       _output_.writeInt32(3, this.point);
/* 115 */       _output_.writeInt64(4, this.update_point_time);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 119 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 121 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 127 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 130 */       boolean done = false;
/* 131 */       while (!done)
/*     */       {
/* 133 */         int tag = _input_.readTag();
/* 134 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 138 */           done = true;
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 143 */           this.campaign = _input_.readInt32();
/* 144 */           break;
/*     */         
/*     */ 
/*     */         case 18: 
/* 148 */           _input_.readMessage(this.vote_award_info);
/* 149 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 153 */           this.point = _input_.readInt32();
/* 154 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 158 */           this.update_point_time = _input_.readInt64();
/* 159 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 163 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 165 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 174 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 178 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 180 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Campaign copy()
/*     */   {
/* 186 */     _xdb_verify_unsafe_();
/* 187 */     return new Campaign(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Campaign toData()
/*     */   {
/* 193 */     _xdb_verify_unsafe_();
/* 194 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Campaign toBean()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new Campaign(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Campaign toDataIf()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Campaign toBeanIf()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCampaign()
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/* 228 */     return this.campaign;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public xbean.VoteAwardInfo getVote_award_info()
/*     */   {
/* 235 */     _xdb_verify_unsafe_();
/* 236 */     return this.vote_award_info;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getPoint()
/*     */   {
/* 243 */     _xdb_verify_unsafe_();
/* 244 */     return this.point;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getUpdate_point_time()
/*     */   {
/* 251 */     _xdb_verify_unsafe_();
/* 252 */     return this.update_point_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCampaign(int _v_)
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     xdb.Logs.logIf(new LogKey(this, "campaign")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 264 */         new LogInt(this, Campaign.this.campaign)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 268 */             Campaign.this.campaign = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 272 */     });
/* 273 */     this.campaign = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPoint(int _v_)
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     xdb.Logs.logIf(new LogKey(this, "point")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 285 */         new LogInt(this, Campaign.this.point)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 289 */             Campaign.this.point = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 293 */     });
/* 294 */     this.point = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUpdate_point_time(long _v_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     xdb.Logs.logIf(new LogKey(this, "update_point_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 306 */         new xdb.logs.LogLong(this, Campaign.this.update_point_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 310 */             Campaign.this.update_point_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 314 */     });
/* 315 */     this.update_point_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     Campaign _o_ = null;
/* 323 */     if ((_o1_ instanceof Campaign)) { _o_ = (Campaign)_o1_;
/* 324 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 325 */       return false;
/* 326 */     if (this.campaign != _o_.campaign) return false;
/* 327 */     if (!this.vote_award_info.equals(_o_.vote_award_info)) return false;
/* 328 */     if (this.point != _o_.point) return false;
/* 329 */     if (this.update_point_time != _o_.update_point_time) return false;
/* 330 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 336 */     _xdb_verify_unsafe_();
/* 337 */     int _h_ = 0;
/* 338 */     _h_ += this.campaign;
/* 339 */     _h_ += this.vote_award_info.hashCode();
/* 340 */     _h_ += this.point;
/* 341 */     _h_ = (int)(_h_ + this.update_point_time);
/* 342 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 348 */     _xdb_verify_unsafe_();
/* 349 */     StringBuilder _sb_ = new StringBuilder();
/* 350 */     _sb_.append("(");
/* 351 */     _sb_.append(this.campaign);
/* 352 */     _sb_.append(",");
/* 353 */     _sb_.append(this.vote_award_info);
/* 354 */     _sb_.append(",");
/* 355 */     _sb_.append(this.point);
/* 356 */     _sb_.append(",");
/* 357 */     _sb_.append(this.update_point_time);
/* 358 */     _sb_.append(")");
/* 359 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 365 */     ListenableBean lb = new ListenableBean();
/* 366 */     lb.add(new ListenableChanged().setVarName("campaign"));
/* 367 */     lb.add(new ListenableChanged().setVarName("vote_award_info"));
/* 368 */     lb.add(new ListenableChanged().setVarName("point"));
/* 369 */     lb.add(new ListenableChanged().setVarName("update_point_time"));
/* 370 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.Campaign {
/*     */     private Const() {}
/*     */     
/*     */     Campaign nThis() {
/* 377 */       return Campaign.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 383 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Campaign copy()
/*     */     {
/* 389 */       return Campaign.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Campaign toData()
/*     */     {
/* 395 */       return Campaign.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.Campaign toBean()
/*     */     {
/* 400 */       return Campaign.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Campaign toDataIf()
/*     */     {
/* 406 */       return Campaign.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.Campaign toBeanIf()
/*     */     {
/* 411 */       return Campaign.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCampaign()
/*     */     {
/* 418 */       Campaign.this._xdb_verify_unsafe_();
/* 419 */       return Campaign.this.campaign;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.VoteAwardInfo getVote_award_info()
/*     */     {
/* 426 */       Campaign.this._xdb_verify_unsafe_();
/* 427 */       return (xbean.VoteAwardInfo)xdb.Consts.toConst(Campaign.this.vote_award_info);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPoint()
/*     */     {
/* 434 */       Campaign.this._xdb_verify_unsafe_();
/* 435 */       return Campaign.this.point;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getUpdate_point_time()
/*     */     {
/* 442 */       Campaign.this._xdb_verify_unsafe_();
/* 443 */       return Campaign.this.update_point_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCampaign(int _v_)
/*     */     {
/* 450 */       Campaign.this._xdb_verify_unsafe_();
/* 451 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPoint(int _v_)
/*     */     {
/* 458 */       Campaign.this._xdb_verify_unsafe_();
/* 459 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setUpdate_point_time(long _v_)
/*     */     {
/* 466 */       Campaign.this._xdb_verify_unsafe_();
/* 467 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 473 */       Campaign.this._xdb_verify_unsafe_();
/* 474 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 480 */       Campaign.this._xdb_verify_unsafe_();
/* 481 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 487 */       return Campaign.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 493 */       return Campaign.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 499 */       Campaign.this._xdb_verify_unsafe_();
/* 500 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 506 */       return Campaign.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 512 */       return Campaign.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 518 */       Campaign.this._xdb_verify_unsafe_();
/* 519 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 525 */       return Campaign.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 531 */       return Campaign.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 537 */       return Campaign.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 543 */       return Campaign.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 549 */       return Campaign.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 555 */       return Campaign.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 561 */       return Campaign.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.Campaign
/*     */   {
/*     */     private int campaign;
/*     */     
/*     */     private xbean.VoteAwardInfo vote_award_info;
/*     */     
/*     */     private int point;
/*     */     
/*     */     private long update_point_time;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 579 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 584 */       this.vote_award_info = new VoteAwardInfo.Data();
/*     */     }
/*     */     
/*     */     Data(xbean.Campaign _o1_)
/*     */     {
/* 589 */       if ((_o1_ instanceof Campaign)) { assign((Campaign)_o1_);
/* 590 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 591 */       } else if ((_o1_ instanceof Campaign.Const)) assign(((Campaign.Const)_o1_).nThis()); else {
/* 592 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Campaign _o_) {
/* 597 */       this.campaign = _o_.campaign;
/* 598 */       this.vote_award_info = new VoteAwardInfo.Data(_o_.vote_award_info);
/* 599 */       this.point = _o_.point;
/* 600 */       this.update_point_time = _o_.update_point_time;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 605 */       this.campaign = _o_.campaign;
/* 606 */       this.vote_award_info = new VoteAwardInfo.Data(_o_.vote_award_info);
/* 607 */       this.point = _o_.point;
/* 608 */       this.update_point_time = _o_.update_point_time;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 614 */       _os_.marshal(this.campaign);
/* 615 */       this.vote_award_info.marshal(_os_);
/* 616 */       _os_.marshal(this.point);
/* 617 */       _os_.marshal(this.update_point_time);
/* 618 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 624 */       this.campaign = _os_.unmarshal_int();
/* 625 */       this.vote_award_info.unmarshal(_os_);
/* 626 */       this.point = _os_.unmarshal_int();
/* 627 */       this.update_point_time = _os_.unmarshal_long();
/* 628 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 634 */       int _size_ = 0;
/* 635 */       _size_ += CodedOutputStream.computeInt32Size(1, this.campaign);
/* 636 */       _size_ += CodedOutputStream.computeMessageSize(2, this.vote_award_info);
/* 637 */       _size_ += CodedOutputStream.computeInt32Size(3, this.point);
/* 638 */       _size_ += CodedOutputStream.computeInt64Size(4, this.update_point_time);
/* 639 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 647 */         _output_.writeInt32(1, this.campaign);
/* 648 */         _output_.writeMessage(2, this.vote_award_info);
/* 649 */         _output_.writeInt32(3, this.point);
/* 650 */         _output_.writeInt64(4, this.update_point_time);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 654 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 656 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 664 */         boolean done = false;
/* 665 */         while (!done)
/*     */         {
/* 667 */           int tag = _input_.readTag();
/* 668 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 672 */             done = true;
/* 673 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 677 */             this.campaign = _input_.readInt32();
/* 678 */             break;
/*     */           
/*     */ 
/*     */           case 18: 
/* 682 */             _input_.readMessage(this.vote_award_info);
/* 683 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 687 */             this.point = _input_.readInt32();
/* 688 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 692 */             this.update_point_time = _input_.readInt64();
/* 693 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 697 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 699 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 708 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 712 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 714 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Campaign copy()
/*     */     {
/* 720 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Campaign toData()
/*     */     {
/* 726 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.Campaign toBean()
/*     */     {
/* 731 */       return new Campaign(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Campaign toDataIf()
/*     */     {
/* 737 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.Campaign toBeanIf()
/*     */     {
/* 742 */       return new Campaign(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 748 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 752 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 756 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 760 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 764 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 768 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 772 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCampaign()
/*     */     {
/* 779 */       return this.campaign;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.VoteAwardInfo getVote_award_info()
/*     */     {
/* 786 */       return this.vote_award_info;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPoint()
/*     */     {
/* 793 */       return this.point;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getUpdate_point_time()
/*     */     {
/* 800 */       return this.update_point_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCampaign(int _v_)
/*     */     {
/* 807 */       this.campaign = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPoint(int _v_)
/*     */     {
/* 814 */       this.point = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setUpdate_point_time(long _v_)
/*     */     {
/* 821 */       this.update_point_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 827 */       if (!(_o1_ instanceof Data)) return false;
/* 828 */       Data _o_ = (Data)_o1_;
/* 829 */       if (this.campaign != _o_.campaign) return false;
/* 830 */       if (!this.vote_award_info.equals(_o_.vote_award_info)) return false;
/* 831 */       if (this.point != _o_.point) return false;
/* 832 */       if (this.update_point_time != _o_.update_point_time) return false;
/* 833 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 839 */       int _h_ = 0;
/* 840 */       _h_ += this.campaign;
/* 841 */       _h_ += this.vote_award_info.hashCode();
/* 842 */       _h_ += this.point;
/* 843 */       _h_ = (int)(_h_ + this.update_point_time);
/* 844 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 850 */       StringBuilder _sb_ = new StringBuilder();
/* 851 */       _sb_.append("(");
/* 852 */       _sb_.append(this.campaign);
/* 853 */       _sb_.append(",");
/* 854 */       _sb_.append(this.vote_award_info);
/* 855 */       _sb_.append(",");
/* 856 */       _sb_.append(this.point);
/* 857 */       _sb_.append(",");
/* 858 */       _sb_.append(this.update_point_time);
/* 859 */       _sb_.append(")");
/* 860 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Campaign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */