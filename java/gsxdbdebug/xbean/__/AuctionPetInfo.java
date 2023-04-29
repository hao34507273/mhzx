/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashSet;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class AuctionPetInfo extends XBean implements xbean.AuctionPetInfo
/*      */ {
/*      */   private long auctionroleid;
/*      */   private long endtime;
/*      */   private int auctioncount;
/*      */   private int auctionprice;
/*      */   private int petcfgid;
/*      */   private SetX<Long> auctionroleset;
/*      */   private boolean issendtip;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.auctionroleid = 0L;
/*   31 */     this.endtime = 0L;
/*   32 */     this.auctioncount = 0;
/*   33 */     this.auctionprice = 0;
/*   34 */     this.petcfgid = 0;
/*   35 */     this.auctionroleset.clear();
/*   36 */     this.issendtip = false;
/*      */   }
/*      */   
/*      */   AuctionPetInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.auctionroleset = new SetX();
/*   43 */     this.issendtip = false;
/*      */   }
/*      */   
/*      */   public AuctionPetInfo()
/*      */   {
/*   48 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public AuctionPetInfo(AuctionPetInfo _o_)
/*      */   {
/*   53 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   AuctionPetInfo(xbean.AuctionPetInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   58 */     super(_xp_, _vn_);
/*   59 */     if ((_o1_ instanceof AuctionPetInfo)) { assign((AuctionPetInfo)_o1_);
/*   60 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   61 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   62 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(AuctionPetInfo _o_) {
/*   67 */     _o_._xdb_verify_unsafe_();
/*   68 */     this.auctionroleid = _o_.auctionroleid;
/*   69 */     this.endtime = _o_.endtime;
/*   70 */     this.auctioncount = _o_.auctioncount;
/*   71 */     this.auctionprice = _o_.auctionprice;
/*   72 */     this.petcfgid = _o_.petcfgid;
/*   73 */     this.auctionroleset = new SetX();
/*   74 */     this.auctionroleset.addAll(_o_.auctionroleset);
/*   75 */     this.issendtip = _o_.issendtip;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   80 */     this.auctionroleid = _o_.auctionroleid;
/*   81 */     this.endtime = _o_.endtime;
/*   82 */     this.auctioncount = _o_.auctioncount;
/*   83 */     this.auctionprice = _o_.auctionprice;
/*   84 */     this.petcfgid = _o_.petcfgid;
/*   85 */     this.auctionroleset = new SetX();
/*   86 */     this.auctionroleset.addAll(_o_.auctionroleset);
/*   87 */     this.issendtip = _o_.issendtip;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   93 */     _xdb_verify_unsafe_();
/*   94 */     _os_.marshal(this.auctionroleid);
/*   95 */     _os_.marshal(this.endtime);
/*   96 */     _os_.marshal(this.auctioncount);
/*   97 */     _os_.marshal(this.auctionprice);
/*   98 */     _os_.marshal(this.petcfgid);
/*   99 */     _os_.compact_uint32(this.auctionroleset.size());
/*  100 */     for (Long _v_ : this.auctionroleset)
/*      */     {
/*  102 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  104 */     _os_.marshal(this.issendtip);
/*  105 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  111 */     _xdb_verify_unsafe_();
/*  112 */     this.auctionroleid = _os_.unmarshal_long();
/*  113 */     this.endtime = _os_.unmarshal_long();
/*  114 */     this.auctioncount = _os_.unmarshal_int();
/*  115 */     this.auctionprice = _os_.unmarshal_int();
/*  116 */     this.petcfgid = _os_.unmarshal_int();
/*  117 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  119 */       long _v_ = 0L;
/*  120 */       _v_ = _os_.unmarshal_long();
/*  121 */       this.auctionroleset.add(Long.valueOf(_v_));
/*      */     }
/*  123 */     this.issendtip = _os_.unmarshal_boolean();
/*  124 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  130 */     _xdb_verify_unsafe_();
/*  131 */     int _size_ = 0;
/*  132 */     _size_ += CodedOutputStream.computeInt64Size(1, this.auctionroleid);
/*  133 */     _size_ += CodedOutputStream.computeInt64Size(2, this.endtime);
/*  134 */     _size_ += CodedOutputStream.computeInt32Size(3, this.auctioncount);
/*  135 */     _size_ += CodedOutputStream.computeInt32Size(4, this.auctionprice);
/*  136 */     _size_ += CodedOutputStream.computeInt32Size(5, this.petcfgid);
/*  137 */     for (Long _v_ : this.auctionroleset)
/*      */     {
/*  139 */       _size_ += CodedOutputStream.computeInt64Size(6, _v_.longValue());
/*      */     }
/*  141 */     _size_ += CodedOutputStream.computeBoolSize(8, this.issendtip);
/*  142 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  148 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  151 */       _output_.writeInt64(1, this.auctionroleid);
/*  152 */       _output_.writeInt64(2, this.endtime);
/*  153 */       _output_.writeInt32(3, this.auctioncount);
/*  154 */       _output_.writeInt32(4, this.auctionprice);
/*  155 */       _output_.writeInt32(5, this.petcfgid);
/*  156 */       for (Long _v_ : this.auctionroleset)
/*      */       {
/*  158 */         _output_.writeInt64(6, _v_.longValue());
/*      */       }
/*  160 */       _output_.writeBool(8, this.issendtip);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  164 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  166 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  172 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  175 */       boolean done = false;
/*  176 */       while (!done)
/*      */       {
/*  178 */         int tag = _input_.readTag();
/*  179 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  183 */           done = true;
/*  184 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  188 */           this.auctionroleid = _input_.readInt64();
/*  189 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  193 */           this.endtime = _input_.readInt64();
/*  194 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  198 */           this.auctioncount = _input_.readInt32();
/*  199 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  203 */           this.auctionprice = _input_.readInt32();
/*  204 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  208 */           this.petcfgid = _input_.readInt32();
/*  209 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  213 */           long _v_ = 0L;
/*  214 */           _v_ = _input_.readInt64();
/*  215 */           this.auctionroleset.add(Long.valueOf(_v_));
/*  216 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  220 */           this.issendtip = _input_.readBool();
/*  221 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  225 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  227 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  236 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  240 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  242 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AuctionPetInfo copy()
/*      */   {
/*  248 */     _xdb_verify_unsafe_();
/*  249 */     return new AuctionPetInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AuctionPetInfo toData()
/*      */   {
/*  255 */     _xdb_verify_unsafe_();
/*  256 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.AuctionPetInfo toBean()
/*      */   {
/*  261 */     _xdb_verify_unsafe_();
/*  262 */     return new AuctionPetInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AuctionPetInfo toDataIf()
/*      */   {
/*  268 */     _xdb_verify_unsafe_();
/*  269 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.AuctionPetInfo toBeanIf()
/*      */   {
/*  274 */     _xdb_verify_unsafe_();
/*  275 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  281 */     _xdb_verify_unsafe_();
/*  282 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getAuctionroleid()
/*      */   {
/*  289 */     _xdb_verify_unsafe_();
/*  290 */     return this.auctionroleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getEndtime()
/*      */   {
/*  297 */     _xdb_verify_unsafe_();
/*  298 */     return this.endtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAuctioncount()
/*      */   {
/*  305 */     _xdb_verify_unsafe_();
/*  306 */     return this.auctioncount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAuctionprice()
/*      */   {
/*  313 */     _xdb_verify_unsafe_();
/*  314 */     return this.auctionprice;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPetcfgid()
/*      */   {
/*  321 */     _xdb_verify_unsafe_();
/*  322 */     return this.petcfgid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getAuctionroleset()
/*      */   {
/*  329 */     _xdb_verify_unsafe_();
/*  330 */     return Logs.logSet(new LogKey(this, "auctionroleset"), this.auctionroleset);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getAuctionrolesetAsData()
/*      */   {
/*  336 */     _xdb_verify_unsafe_();
/*      */     
/*  338 */     AuctionPetInfo _o_ = this;
/*  339 */     Set<Long> auctionroleset = new SetX();
/*  340 */     auctionroleset.addAll(_o_.auctionroleset);
/*  341 */     return auctionroleset;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIssendtip()
/*      */   {
/*  348 */     _xdb_verify_unsafe_();
/*  349 */     return this.issendtip;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAuctionroleid(long _v_)
/*      */   {
/*  356 */     _xdb_verify_unsafe_();
/*  357 */     Logs.logIf(new LogKey(this, "auctionroleid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  361 */         new xdb.logs.LogLong(this, AuctionPetInfo.this.auctionroleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  365 */             AuctionPetInfo.this.auctionroleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  369 */     });
/*  370 */     this.auctionroleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setEndtime(long _v_)
/*      */   {
/*  377 */     _xdb_verify_unsafe_();
/*  378 */     Logs.logIf(new LogKey(this, "endtime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  382 */         new xdb.logs.LogLong(this, AuctionPetInfo.this.endtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  386 */             AuctionPetInfo.this.endtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  390 */     });
/*  391 */     this.endtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAuctioncount(int _v_)
/*      */   {
/*  398 */     _xdb_verify_unsafe_();
/*  399 */     Logs.logIf(new LogKey(this, "auctioncount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  403 */         new xdb.logs.LogInt(this, AuctionPetInfo.this.auctioncount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  407 */             AuctionPetInfo.this.auctioncount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  411 */     });
/*  412 */     this.auctioncount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAuctionprice(int _v_)
/*      */   {
/*  419 */     _xdb_verify_unsafe_();
/*  420 */     Logs.logIf(new LogKey(this, "auctionprice")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  424 */         new xdb.logs.LogInt(this, AuctionPetInfo.this.auctionprice)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  428 */             AuctionPetInfo.this.auctionprice = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  432 */     });
/*  433 */     this.auctionprice = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPetcfgid(int _v_)
/*      */   {
/*  440 */     _xdb_verify_unsafe_();
/*  441 */     Logs.logIf(new LogKey(this, "petcfgid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  445 */         new xdb.logs.LogInt(this, AuctionPetInfo.this.petcfgid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  449 */             AuctionPetInfo.this.petcfgid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  453 */     });
/*  454 */     this.petcfgid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIssendtip(boolean _v_)
/*      */   {
/*  461 */     _xdb_verify_unsafe_();
/*  462 */     Logs.logIf(new LogKey(this, "issendtip")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  466 */         new xdb.logs.LogObject(this, Boolean.valueOf(AuctionPetInfo.this.issendtip))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  470 */             AuctionPetInfo.this.issendtip = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  474 */     });
/*  475 */     this.issendtip = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  481 */     _xdb_verify_unsafe_();
/*  482 */     AuctionPetInfo _o_ = null;
/*  483 */     if ((_o1_ instanceof AuctionPetInfo)) { _o_ = (AuctionPetInfo)_o1_;
/*  484 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  485 */       return false;
/*  486 */     if (this.auctionroleid != _o_.auctionroleid) return false;
/*  487 */     if (this.endtime != _o_.endtime) return false;
/*  488 */     if (this.auctioncount != _o_.auctioncount) return false;
/*  489 */     if (this.auctionprice != _o_.auctionprice) return false;
/*  490 */     if (this.petcfgid != _o_.petcfgid) return false;
/*  491 */     if (!this.auctionroleset.equals(_o_.auctionroleset)) return false;
/*  492 */     if (this.issendtip != _o_.issendtip) return false;
/*  493 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  499 */     _xdb_verify_unsafe_();
/*  500 */     int _h_ = 0;
/*  501 */     _h_ = (int)(_h_ + this.auctionroleid);
/*  502 */     _h_ = (int)(_h_ + this.endtime);
/*  503 */     _h_ += this.auctioncount;
/*  504 */     _h_ += this.auctionprice;
/*  505 */     _h_ += this.petcfgid;
/*  506 */     _h_ += this.auctionroleset.hashCode();
/*  507 */     _h_ += (this.issendtip ? 1231 : 1237);
/*  508 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  514 */     _xdb_verify_unsafe_();
/*  515 */     StringBuilder _sb_ = new StringBuilder();
/*  516 */     _sb_.append("(");
/*  517 */     _sb_.append(this.auctionroleid);
/*  518 */     _sb_.append(",");
/*  519 */     _sb_.append(this.endtime);
/*  520 */     _sb_.append(",");
/*  521 */     _sb_.append(this.auctioncount);
/*  522 */     _sb_.append(",");
/*  523 */     _sb_.append(this.auctionprice);
/*  524 */     _sb_.append(",");
/*  525 */     _sb_.append(this.petcfgid);
/*  526 */     _sb_.append(",");
/*  527 */     _sb_.append(this.auctionroleset);
/*  528 */     _sb_.append(",");
/*  529 */     _sb_.append(this.issendtip);
/*  530 */     _sb_.append(")");
/*  531 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  537 */     ListenableBean lb = new ListenableBean();
/*  538 */     lb.add(new ListenableChanged().setVarName("auctionroleid"));
/*  539 */     lb.add(new ListenableChanged().setVarName("endtime"));
/*  540 */     lb.add(new ListenableChanged().setVarName("auctioncount"));
/*  541 */     lb.add(new ListenableChanged().setVarName("auctionprice"));
/*  542 */     lb.add(new ListenableChanged().setVarName("petcfgid"));
/*  543 */     lb.add(new xdb.logs.ListenableSet().setVarName("auctionroleset"));
/*  544 */     lb.add(new ListenableChanged().setVarName("issendtip"));
/*  545 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.AuctionPetInfo {
/*      */     private Const() {}
/*      */     
/*      */     AuctionPetInfo nThis() {
/*  552 */       return AuctionPetInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  558 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AuctionPetInfo copy()
/*      */     {
/*  564 */       return AuctionPetInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AuctionPetInfo toData()
/*      */     {
/*  570 */       return AuctionPetInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.AuctionPetInfo toBean()
/*      */     {
/*  575 */       return AuctionPetInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AuctionPetInfo toDataIf()
/*      */     {
/*  581 */       return AuctionPetInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.AuctionPetInfo toBeanIf()
/*      */     {
/*  586 */       return AuctionPetInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAuctionroleid()
/*      */     {
/*  593 */       AuctionPetInfo.this._xdb_verify_unsafe_();
/*  594 */       return AuctionPetInfo.this.auctionroleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEndtime()
/*      */     {
/*  601 */       AuctionPetInfo.this._xdb_verify_unsafe_();
/*  602 */       return AuctionPetInfo.this.endtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAuctioncount()
/*      */     {
/*  609 */       AuctionPetInfo.this._xdb_verify_unsafe_();
/*  610 */       return AuctionPetInfo.this.auctioncount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAuctionprice()
/*      */     {
/*  617 */       AuctionPetInfo.this._xdb_verify_unsafe_();
/*  618 */       return AuctionPetInfo.this.auctionprice;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPetcfgid()
/*      */     {
/*  625 */       AuctionPetInfo.this._xdb_verify_unsafe_();
/*  626 */       return AuctionPetInfo.this.petcfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getAuctionroleset()
/*      */     {
/*  633 */       AuctionPetInfo.this._xdb_verify_unsafe_();
/*  634 */       return xdb.Consts.constSet(AuctionPetInfo.this.auctionroleset);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getAuctionrolesetAsData()
/*      */     {
/*  640 */       AuctionPetInfo.this._xdb_verify_unsafe_();
/*      */       
/*  642 */       AuctionPetInfo _o_ = AuctionPetInfo.this;
/*  643 */       Set<Long> auctionroleset = new SetX();
/*  644 */       auctionroleset.addAll(_o_.auctionroleset);
/*  645 */       return auctionroleset;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIssendtip()
/*      */     {
/*  652 */       AuctionPetInfo.this._xdb_verify_unsafe_();
/*  653 */       return AuctionPetInfo.this.issendtip;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAuctionroleid(long _v_)
/*      */     {
/*  660 */       AuctionPetInfo.this._xdb_verify_unsafe_();
/*  661 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEndtime(long _v_)
/*      */     {
/*  668 */       AuctionPetInfo.this._xdb_verify_unsafe_();
/*  669 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAuctioncount(int _v_)
/*      */     {
/*  676 */       AuctionPetInfo.this._xdb_verify_unsafe_();
/*  677 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAuctionprice(int _v_)
/*      */     {
/*  684 */       AuctionPetInfo.this._xdb_verify_unsafe_();
/*  685 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPetcfgid(int _v_)
/*      */     {
/*  692 */       AuctionPetInfo.this._xdb_verify_unsafe_();
/*  693 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIssendtip(boolean _v_)
/*      */     {
/*  700 */       AuctionPetInfo.this._xdb_verify_unsafe_();
/*  701 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  707 */       AuctionPetInfo.this._xdb_verify_unsafe_();
/*  708 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  714 */       AuctionPetInfo.this._xdb_verify_unsafe_();
/*  715 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  721 */       return AuctionPetInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  727 */       return AuctionPetInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  733 */       AuctionPetInfo.this._xdb_verify_unsafe_();
/*  734 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  740 */       return AuctionPetInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  746 */       return AuctionPetInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  752 */       AuctionPetInfo.this._xdb_verify_unsafe_();
/*  753 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  759 */       return AuctionPetInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  765 */       return AuctionPetInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  771 */       return AuctionPetInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  777 */       return AuctionPetInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  783 */       return AuctionPetInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  789 */       return AuctionPetInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  795 */       return AuctionPetInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.AuctionPetInfo
/*      */   {
/*      */     private long auctionroleid;
/*      */     
/*      */     private long endtime;
/*      */     
/*      */     private int auctioncount;
/*      */     
/*      */     private int auctionprice;
/*      */     
/*      */     private int petcfgid;
/*      */     
/*      */     private HashSet<Long> auctionroleset;
/*      */     
/*      */     private boolean issendtip;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  819 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  824 */       this.auctionroleset = new HashSet();
/*  825 */       this.issendtip = false;
/*      */     }
/*      */     
/*      */     Data(xbean.AuctionPetInfo _o1_)
/*      */     {
/*  830 */       if ((_o1_ instanceof AuctionPetInfo)) { assign((AuctionPetInfo)_o1_);
/*  831 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  832 */       } else if ((_o1_ instanceof AuctionPetInfo.Const)) assign(((AuctionPetInfo.Const)_o1_).nThis()); else {
/*  833 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(AuctionPetInfo _o_) {
/*  838 */       this.auctionroleid = _o_.auctionroleid;
/*  839 */       this.endtime = _o_.endtime;
/*  840 */       this.auctioncount = _o_.auctioncount;
/*  841 */       this.auctionprice = _o_.auctionprice;
/*  842 */       this.petcfgid = _o_.petcfgid;
/*  843 */       this.auctionroleset = new HashSet();
/*  844 */       this.auctionroleset.addAll(_o_.auctionroleset);
/*  845 */       this.issendtip = _o_.issendtip;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  850 */       this.auctionroleid = _o_.auctionroleid;
/*  851 */       this.endtime = _o_.endtime;
/*  852 */       this.auctioncount = _o_.auctioncount;
/*  853 */       this.auctionprice = _o_.auctionprice;
/*  854 */       this.petcfgid = _o_.petcfgid;
/*  855 */       this.auctionroleset = new HashSet();
/*  856 */       this.auctionroleset.addAll(_o_.auctionroleset);
/*  857 */       this.issendtip = _o_.issendtip;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  863 */       _os_.marshal(this.auctionroleid);
/*  864 */       _os_.marshal(this.endtime);
/*  865 */       _os_.marshal(this.auctioncount);
/*  866 */       _os_.marshal(this.auctionprice);
/*  867 */       _os_.marshal(this.petcfgid);
/*  868 */       _os_.compact_uint32(this.auctionroleset.size());
/*  869 */       for (Long _v_ : this.auctionroleset)
/*      */       {
/*  871 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  873 */       _os_.marshal(this.issendtip);
/*  874 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  880 */       this.auctionroleid = _os_.unmarshal_long();
/*  881 */       this.endtime = _os_.unmarshal_long();
/*  882 */       this.auctioncount = _os_.unmarshal_int();
/*  883 */       this.auctionprice = _os_.unmarshal_int();
/*  884 */       this.petcfgid = _os_.unmarshal_int();
/*  885 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  887 */         long _v_ = 0L;
/*  888 */         _v_ = _os_.unmarshal_long();
/*  889 */         this.auctionroleset.add(Long.valueOf(_v_));
/*      */       }
/*  891 */       this.issendtip = _os_.unmarshal_boolean();
/*  892 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  898 */       int _size_ = 0;
/*  899 */       _size_ += CodedOutputStream.computeInt64Size(1, this.auctionroleid);
/*  900 */       _size_ += CodedOutputStream.computeInt64Size(2, this.endtime);
/*  901 */       _size_ += CodedOutputStream.computeInt32Size(3, this.auctioncount);
/*  902 */       _size_ += CodedOutputStream.computeInt32Size(4, this.auctionprice);
/*  903 */       _size_ += CodedOutputStream.computeInt32Size(5, this.petcfgid);
/*  904 */       for (Long _v_ : this.auctionroleset)
/*      */       {
/*  906 */         _size_ += CodedOutputStream.computeInt64Size(6, _v_.longValue());
/*      */       }
/*  908 */       _size_ += CodedOutputStream.computeBoolSize(8, this.issendtip);
/*  909 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  917 */         _output_.writeInt64(1, this.auctionroleid);
/*  918 */         _output_.writeInt64(2, this.endtime);
/*  919 */         _output_.writeInt32(3, this.auctioncount);
/*  920 */         _output_.writeInt32(4, this.auctionprice);
/*  921 */         _output_.writeInt32(5, this.petcfgid);
/*  922 */         for (Long _v_ : this.auctionroleset)
/*      */         {
/*  924 */           _output_.writeInt64(6, _v_.longValue());
/*      */         }
/*  926 */         _output_.writeBool(8, this.issendtip);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  930 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  932 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  940 */         boolean done = false;
/*  941 */         while (!done)
/*      */         {
/*  943 */           int tag = _input_.readTag();
/*  944 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  948 */             done = true;
/*  949 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  953 */             this.auctionroleid = _input_.readInt64();
/*  954 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  958 */             this.endtime = _input_.readInt64();
/*  959 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  963 */             this.auctioncount = _input_.readInt32();
/*  964 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  968 */             this.auctionprice = _input_.readInt32();
/*  969 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  973 */             this.petcfgid = _input_.readInt32();
/*  974 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  978 */             long _v_ = 0L;
/*  979 */             _v_ = _input_.readInt64();
/*  980 */             this.auctionroleset.add(Long.valueOf(_v_));
/*  981 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/*  985 */             this.issendtip = _input_.readBool();
/*  986 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  990 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  992 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1001 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1005 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1007 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AuctionPetInfo copy()
/*      */     {
/* 1013 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AuctionPetInfo toData()
/*      */     {
/* 1019 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.AuctionPetInfo toBean()
/*      */     {
/* 1024 */       return new AuctionPetInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AuctionPetInfo toDataIf()
/*      */     {
/* 1030 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.AuctionPetInfo toBeanIf()
/*      */     {
/* 1035 */       return new AuctionPetInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1041 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1045 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1049 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1053 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1057 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1061 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1065 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAuctionroleid()
/*      */     {
/* 1072 */       return this.auctionroleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEndtime()
/*      */     {
/* 1079 */       return this.endtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAuctioncount()
/*      */     {
/* 1086 */       return this.auctioncount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAuctionprice()
/*      */     {
/* 1093 */       return this.auctionprice;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPetcfgid()
/*      */     {
/* 1100 */       return this.petcfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getAuctionroleset()
/*      */     {
/* 1107 */       return this.auctionroleset;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getAuctionrolesetAsData()
/*      */     {
/* 1114 */       return this.auctionroleset;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIssendtip()
/*      */     {
/* 1121 */       return this.issendtip;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAuctionroleid(long _v_)
/*      */     {
/* 1128 */       this.auctionroleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEndtime(long _v_)
/*      */     {
/* 1135 */       this.endtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAuctioncount(int _v_)
/*      */     {
/* 1142 */       this.auctioncount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAuctionprice(int _v_)
/*      */     {
/* 1149 */       this.auctionprice = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPetcfgid(int _v_)
/*      */     {
/* 1156 */       this.petcfgid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIssendtip(boolean _v_)
/*      */     {
/* 1163 */       this.issendtip = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1169 */       if (!(_o1_ instanceof Data)) return false;
/* 1170 */       Data _o_ = (Data)_o1_;
/* 1171 */       if (this.auctionroleid != _o_.auctionroleid) return false;
/* 1172 */       if (this.endtime != _o_.endtime) return false;
/* 1173 */       if (this.auctioncount != _o_.auctioncount) return false;
/* 1174 */       if (this.auctionprice != _o_.auctionprice) return false;
/* 1175 */       if (this.petcfgid != _o_.petcfgid) return false;
/* 1176 */       if (!this.auctionroleset.equals(_o_.auctionroleset)) return false;
/* 1177 */       if (this.issendtip != _o_.issendtip) return false;
/* 1178 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1184 */       int _h_ = 0;
/* 1185 */       _h_ = (int)(_h_ + this.auctionroleid);
/* 1186 */       _h_ = (int)(_h_ + this.endtime);
/* 1187 */       _h_ += this.auctioncount;
/* 1188 */       _h_ += this.auctionprice;
/* 1189 */       _h_ += this.petcfgid;
/* 1190 */       _h_ += this.auctionroleset.hashCode();
/* 1191 */       _h_ += (this.issendtip ? 1231 : 1237);
/* 1192 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1198 */       StringBuilder _sb_ = new StringBuilder();
/* 1199 */       _sb_.append("(");
/* 1200 */       _sb_.append(this.auctionroleid);
/* 1201 */       _sb_.append(",");
/* 1202 */       _sb_.append(this.endtime);
/* 1203 */       _sb_.append(",");
/* 1204 */       _sb_.append(this.auctioncount);
/* 1205 */       _sb_.append(",");
/* 1206 */       _sb_.append(this.auctionprice);
/* 1207 */       _sb_.append(",");
/* 1208 */       _sb_.append(this.petcfgid);
/* 1209 */       _sb_.append(",");
/* 1210 */       _sb_.append(this.auctionroleset);
/* 1211 */       _sb_.append(",");
/* 1212 */       _sb_.append(this.issendtip);
/* 1213 */       _sb_.append(")");
/* 1214 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\AuctionPetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */