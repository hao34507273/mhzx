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
/*     */ 
/*     */ public final class TeamDispositionMember extends XBean implements xbean.TeamDispositionMember
/*     */ {
/*     */   private long dispositionmemberid;
/*     */   private int dispositionmembertype;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.dispositionmemberid = 0L;
/*  21 */     this.dispositionmembertype = 0;
/*     */   }
/*     */   
/*     */   TeamDispositionMember(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public TeamDispositionMember()
/*     */   {
/*  31 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public TeamDispositionMember(TeamDispositionMember _o_)
/*     */   {
/*  36 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   TeamDispositionMember(xbean.TeamDispositionMember _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  41 */     super(_xp_, _vn_);
/*  42 */     if ((_o1_ instanceof TeamDispositionMember)) { assign((TeamDispositionMember)_o1_);
/*  43 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  44 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  45 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(TeamDispositionMember _o_) {
/*  50 */     _o_._xdb_verify_unsafe_();
/*  51 */     this.dispositionmemberid = _o_.dispositionmemberid;
/*  52 */     this.dispositionmembertype = _o_.dispositionmembertype;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  57 */     this.dispositionmemberid = _o_.dispositionmemberid;
/*  58 */     this.dispositionmembertype = _o_.dispositionmembertype;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  64 */     _xdb_verify_unsafe_();
/*  65 */     _os_.marshal(this.dispositionmemberid);
/*  66 */     _os_.marshal(this.dispositionmembertype);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  73 */     _xdb_verify_unsafe_();
/*  74 */     this.dispositionmemberid = _os_.unmarshal_long();
/*  75 */     this.dispositionmembertype = _os_.unmarshal_int();
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     int _size_ = 0;
/*  84 */     _size_ += CodedOutputStream.computeInt64Size(1, this.dispositionmemberid);
/*  85 */     _size_ += CodedOutputStream.computeInt32Size(2, this.dispositionmembertype);
/*  86 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  95 */       _output_.writeInt64(1, this.dispositionmemberid);
/*  96 */       _output_.writeInt32(2, this.dispositionmembertype);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 100 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 102 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       boolean done = false;
/* 112 */       while (!done)
/*     */       {
/* 114 */         int tag = _input_.readTag();
/* 115 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 119 */           done = true;
/* 120 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 124 */           this.dispositionmemberid = _input_.readInt64();
/* 125 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 129 */           this.dispositionmembertype = _input_.readInt32();
/* 130 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 134 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 136 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 145 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 149 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 151 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.TeamDispositionMember copy()
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/* 158 */     return new TeamDispositionMember(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.TeamDispositionMember toData()
/*     */   {
/* 164 */     _xdb_verify_unsafe_();
/* 165 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.TeamDispositionMember toBean()
/*     */   {
/* 170 */     _xdb_verify_unsafe_();
/* 171 */     return new TeamDispositionMember(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.TeamDispositionMember toDataIf()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.TeamDispositionMember toBeanIf()
/*     */   {
/* 183 */     _xdb_verify_unsafe_();
/* 184 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 190 */     _xdb_verify_unsafe_();
/* 191 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getDispositionmemberid()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return this.dispositionmemberid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getDispositionmembertype()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return this.dispositionmembertype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDispositionmemberid(long _v_)
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     xdb.Logs.logIf(new LogKey(this, "dispositionmemberid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 219 */         new xdb.logs.LogLong(this, TeamDispositionMember.this.dispositionmemberid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 223 */             TeamDispositionMember.this.dispositionmemberid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 227 */     });
/* 228 */     this.dispositionmemberid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDispositionmembertype(int _v_)
/*     */   {
/* 235 */     _xdb_verify_unsafe_();
/* 236 */     xdb.Logs.logIf(new LogKey(this, "dispositionmembertype")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 240 */         new xdb.logs.LogInt(this, TeamDispositionMember.this.dispositionmembertype)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 244 */             TeamDispositionMember.this.dispositionmembertype = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 248 */     });
/* 249 */     this.dispositionmembertype = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/* 256 */     TeamDispositionMember _o_ = null;
/* 257 */     if ((_o1_ instanceof TeamDispositionMember)) { _o_ = (TeamDispositionMember)_o1_;
/* 258 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 259 */       return false;
/* 260 */     if (this.dispositionmemberid != _o_.dispositionmemberid) return false;
/* 261 */     if (this.dispositionmembertype != _o_.dispositionmembertype) return false;
/* 262 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     int _h_ = 0;
/* 270 */     _h_ = (int)(_h_ + this.dispositionmemberid);
/* 271 */     _h_ += this.dispositionmembertype;
/* 272 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     StringBuilder _sb_ = new StringBuilder();
/* 280 */     _sb_.append("(");
/* 281 */     _sb_.append(this.dispositionmemberid);
/* 282 */     _sb_.append(",");
/* 283 */     _sb_.append(this.dispositionmembertype);
/* 284 */     _sb_.append(")");
/* 285 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 291 */     ListenableBean lb = new ListenableBean();
/* 292 */     lb.add(new xdb.logs.ListenableChanged().setVarName("dispositionmemberid"));
/* 293 */     lb.add(new xdb.logs.ListenableChanged().setVarName("dispositionmembertype"));
/* 294 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.TeamDispositionMember {
/*     */     private Const() {}
/*     */     
/*     */     TeamDispositionMember nThis() {
/* 301 */       return TeamDispositionMember.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 307 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TeamDispositionMember copy()
/*     */     {
/* 313 */       return TeamDispositionMember.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TeamDispositionMember toData()
/*     */     {
/* 319 */       return TeamDispositionMember.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.TeamDispositionMember toBean()
/*     */     {
/* 324 */       return TeamDispositionMember.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TeamDispositionMember toDataIf()
/*     */     {
/* 330 */       return TeamDispositionMember.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.TeamDispositionMember toBeanIf()
/*     */     {
/* 335 */       return TeamDispositionMember.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getDispositionmemberid()
/*     */     {
/* 342 */       TeamDispositionMember.this._xdb_verify_unsafe_();
/* 343 */       return TeamDispositionMember.this.dispositionmemberid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getDispositionmembertype()
/*     */     {
/* 350 */       TeamDispositionMember.this._xdb_verify_unsafe_();
/* 351 */       return TeamDispositionMember.this.dispositionmembertype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDispositionmemberid(long _v_)
/*     */     {
/* 358 */       TeamDispositionMember.this._xdb_verify_unsafe_();
/* 359 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDispositionmembertype(int _v_)
/*     */     {
/* 366 */       TeamDispositionMember.this._xdb_verify_unsafe_();
/* 367 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 373 */       TeamDispositionMember.this._xdb_verify_unsafe_();
/* 374 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 380 */       TeamDispositionMember.this._xdb_verify_unsafe_();
/* 381 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 387 */       return TeamDispositionMember.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 393 */       return TeamDispositionMember.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 399 */       TeamDispositionMember.this._xdb_verify_unsafe_();
/* 400 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 406 */       return TeamDispositionMember.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 412 */       return TeamDispositionMember.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 418 */       TeamDispositionMember.this._xdb_verify_unsafe_();
/* 419 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 425 */       return TeamDispositionMember.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 431 */       return TeamDispositionMember.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 437 */       return TeamDispositionMember.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 443 */       return TeamDispositionMember.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 449 */       return TeamDispositionMember.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 455 */       return TeamDispositionMember.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 461 */       return TeamDispositionMember.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.TeamDispositionMember
/*     */   {
/*     */     private long dispositionmemberid;
/*     */     
/*     */     private int dispositionmembertype;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 475 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.TeamDispositionMember _o1_)
/*     */     {
/* 484 */       if ((_o1_ instanceof TeamDispositionMember)) { assign((TeamDispositionMember)_o1_);
/* 485 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 486 */       } else if ((_o1_ instanceof TeamDispositionMember.Const)) assign(((TeamDispositionMember.Const)_o1_).nThis()); else {
/* 487 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(TeamDispositionMember _o_) {
/* 492 */       this.dispositionmemberid = _o_.dispositionmemberid;
/* 493 */       this.dispositionmembertype = _o_.dispositionmembertype;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 498 */       this.dispositionmemberid = _o_.dispositionmemberid;
/* 499 */       this.dispositionmembertype = _o_.dispositionmembertype;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 505 */       _os_.marshal(this.dispositionmemberid);
/* 506 */       _os_.marshal(this.dispositionmembertype);
/* 507 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 513 */       this.dispositionmemberid = _os_.unmarshal_long();
/* 514 */       this.dispositionmembertype = _os_.unmarshal_int();
/* 515 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 521 */       int _size_ = 0;
/* 522 */       _size_ += CodedOutputStream.computeInt64Size(1, this.dispositionmemberid);
/* 523 */       _size_ += CodedOutputStream.computeInt32Size(2, this.dispositionmembertype);
/* 524 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 532 */         _output_.writeInt64(1, this.dispositionmemberid);
/* 533 */         _output_.writeInt32(2, this.dispositionmembertype);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 537 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 539 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 547 */         boolean done = false;
/* 548 */         while (!done)
/*     */         {
/* 550 */           int tag = _input_.readTag();
/* 551 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 555 */             done = true;
/* 556 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 560 */             this.dispositionmemberid = _input_.readInt64();
/* 561 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 565 */             this.dispositionmembertype = _input_.readInt32();
/* 566 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 570 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 572 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 581 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 585 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 587 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TeamDispositionMember copy()
/*     */     {
/* 593 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TeamDispositionMember toData()
/*     */     {
/* 599 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.TeamDispositionMember toBean()
/*     */     {
/* 604 */       return new TeamDispositionMember(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TeamDispositionMember toDataIf()
/*     */     {
/* 610 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.TeamDispositionMember toBeanIf()
/*     */     {
/* 615 */       return new TeamDispositionMember(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 621 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 625 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 629 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 633 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 637 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 641 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 645 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getDispositionmemberid()
/*     */     {
/* 652 */       return this.dispositionmemberid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getDispositionmembertype()
/*     */     {
/* 659 */       return this.dispositionmembertype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDispositionmemberid(long _v_)
/*     */     {
/* 666 */       this.dispositionmemberid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDispositionmembertype(int _v_)
/*     */     {
/* 673 */       this.dispositionmembertype = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 679 */       if (!(_o1_ instanceof Data)) return false;
/* 680 */       Data _o_ = (Data)_o1_;
/* 681 */       if (this.dispositionmemberid != _o_.dispositionmemberid) return false;
/* 682 */       if (this.dispositionmembertype != _o_.dispositionmembertype) return false;
/* 683 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 689 */       int _h_ = 0;
/* 690 */       _h_ = (int)(_h_ + this.dispositionmemberid);
/* 691 */       _h_ += this.dispositionmembertype;
/* 692 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 698 */       StringBuilder _sb_ = new StringBuilder();
/* 699 */       _sb_.append("(");
/* 700 */       _sb_.append(this.dispositionmemberid);
/* 701 */       _sb_.append(",");
/* 702 */       _sb_.append(this.dispositionmembertype);
/* 703 */       _sb_.append(")");
/* 704 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\TeamDispositionMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */