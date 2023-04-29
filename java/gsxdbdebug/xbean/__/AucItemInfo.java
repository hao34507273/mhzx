/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
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
/*      */ import xdb.logs.LogLong;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class AucItemInfo extends XBean implements xbean.AucItemInfo
/*      */ {
/*      */   private int itemcfgid;
/*      */   private SetX<Long> bidderroleidset;
/*      */   private long maxbidprice;
/*      */   private long bidderroleid;
/*      */   private String bidderrolename;
/*      */   private long bidendtimestamp;
/*      */   private long bidendfinaltimestamp;
/*      */   private int issend;
/*      */   private long bidendsessionid;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   34 */     this.itemcfgid = 0;
/*   35 */     this.bidderroleidset.clear();
/*   36 */     this.maxbidprice = 0L;
/*   37 */     this.bidderroleid = 0L;
/*   38 */     this.bidderrolename = "";
/*   39 */     this.bidendtimestamp = 0L;
/*   40 */     this.bidendfinaltimestamp = 0L;
/*   41 */     this.issend = 0;
/*   42 */     this.bidendsessionid = 0L;
/*      */   }
/*      */   
/*      */   AucItemInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   47 */     super(_xp_, _vn_);
/*   48 */     this.bidderroleidset = new SetX();
/*   49 */     this.bidderrolename = "";
/*      */   }
/*      */   
/*      */   public AucItemInfo()
/*      */   {
/*   54 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public AucItemInfo(AucItemInfo _o_)
/*      */   {
/*   59 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   AucItemInfo(xbean.AucItemInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   64 */     super(_xp_, _vn_);
/*   65 */     if ((_o1_ instanceof AucItemInfo)) { assign((AucItemInfo)_o1_);
/*   66 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   67 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   68 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(AucItemInfo _o_) {
/*   73 */     _o_._xdb_verify_unsafe_();
/*   74 */     this.itemcfgid = _o_.itemcfgid;
/*   75 */     this.bidderroleidset = new SetX();
/*   76 */     this.bidderroleidset.addAll(_o_.bidderroleidset);
/*   77 */     this.maxbidprice = _o_.maxbidprice;
/*   78 */     this.bidderroleid = _o_.bidderroleid;
/*   79 */     this.bidderrolename = _o_.bidderrolename;
/*   80 */     this.bidendtimestamp = _o_.bidendtimestamp;
/*   81 */     this.bidendfinaltimestamp = _o_.bidendfinaltimestamp;
/*   82 */     this.issend = _o_.issend;
/*   83 */     this.bidendsessionid = _o_.bidendsessionid;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   88 */     this.itemcfgid = _o_.itemcfgid;
/*   89 */     this.bidderroleidset = new SetX();
/*   90 */     this.bidderroleidset.addAll(_o_.bidderroleidset);
/*   91 */     this.maxbidprice = _o_.maxbidprice;
/*   92 */     this.bidderroleid = _o_.bidderroleid;
/*   93 */     this.bidderrolename = _o_.bidderrolename;
/*   94 */     this.bidendtimestamp = _o_.bidendtimestamp;
/*   95 */     this.bidendfinaltimestamp = _o_.bidendfinaltimestamp;
/*   96 */     this.issend = _o_.issend;
/*   97 */     this.bidendsessionid = _o_.bidendsessionid;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  103 */     _xdb_verify_unsafe_();
/*  104 */     _os_.marshal(this.itemcfgid);
/*  105 */     _os_.compact_uint32(this.bidderroleidset.size());
/*  106 */     for (Long _v_ : this.bidderroleidset)
/*      */     {
/*  108 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  110 */     _os_.marshal(this.maxbidprice);
/*  111 */     _os_.marshal(this.bidderroleid);
/*  112 */     _os_.marshal(this.bidderrolename, "UTF-16LE");
/*  113 */     _os_.marshal(this.bidendtimestamp);
/*  114 */     _os_.marshal(this.bidendfinaltimestamp);
/*  115 */     _os_.marshal(this.issend);
/*  116 */     _os_.marshal(this.bidendsessionid);
/*  117 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  123 */     _xdb_verify_unsafe_();
/*  124 */     this.itemcfgid = _os_.unmarshal_int();
/*  125 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  127 */       long _v_ = 0L;
/*  128 */       _v_ = _os_.unmarshal_long();
/*  129 */       this.bidderroleidset.add(Long.valueOf(_v_));
/*      */     }
/*  131 */     this.maxbidprice = _os_.unmarshal_long();
/*  132 */     this.bidderroleid = _os_.unmarshal_long();
/*  133 */     this.bidderrolename = _os_.unmarshal_String("UTF-16LE");
/*  134 */     this.bidendtimestamp = _os_.unmarshal_long();
/*  135 */     this.bidendfinaltimestamp = _os_.unmarshal_long();
/*  136 */     this.issend = _os_.unmarshal_int();
/*  137 */     this.bidendsessionid = _os_.unmarshal_long();
/*  138 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  144 */     _xdb_verify_unsafe_();
/*  145 */     int _size_ = 0;
/*  146 */     _size_ += CodedOutputStream.computeInt32Size(1, this.itemcfgid);
/*  147 */     for (Long _v_ : this.bidderroleidset)
/*      */     {
/*  149 */       _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*      */     }
/*  151 */     _size_ += CodedOutputStream.computeInt64Size(3, this.maxbidprice);
/*  152 */     _size_ += CodedOutputStream.computeInt64Size(4, this.bidderroleid);
/*      */     try
/*      */     {
/*  155 */       _size_ += CodedOutputStream.computeBytesSize(5, ppbio.ByteString.copyFrom(this.bidderrolename, "UTF-16LE"));
/*      */     }
/*      */     catch (java.io.UnsupportedEncodingException e)
/*      */     {
/*  159 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  161 */     _size_ += CodedOutputStream.computeInt64Size(6, this.bidendtimestamp);
/*  162 */     _size_ += CodedOutputStream.computeInt64Size(7, this.bidendfinaltimestamp);
/*  163 */     _size_ += CodedOutputStream.computeInt32Size(8, this.issend);
/*  164 */     _size_ += CodedOutputStream.computeInt64Size(9, this.bidendsessionid);
/*  165 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  171 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  174 */       _output_.writeInt32(1, this.itemcfgid);
/*  175 */       for (Long _v_ : this.bidderroleidset)
/*      */       {
/*  177 */         _output_.writeInt64(2, _v_.longValue());
/*      */       }
/*  179 */       _output_.writeInt64(3, this.maxbidprice);
/*  180 */       _output_.writeInt64(4, this.bidderroleid);
/*  181 */       _output_.writeBytes(5, ppbio.ByteString.copyFrom(this.bidderrolename, "UTF-16LE"));
/*  182 */       _output_.writeInt64(6, this.bidendtimestamp);
/*  183 */       _output_.writeInt64(7, this.bidendfinaltimestamp);
/*  184 */       _output_.writeInt32(8, this.issend);
/*  185 */       _output_.writeInt64(9, this.bidendsessionid);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  189 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  191 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  197 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  200 */       boolean done = false;
/*  201 */       while (!done)
/*      */       {
/*  203 */         int tag = _input_.readTag();
/*  204 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  208 */           done = true;
/*  209 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  213 */           this.itemcfgid = _input_.readInt32();
/*  214 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  218 */           long _v_ = 0L;
/*  219 */           _v_ = _input_.readInt64();
/*  220 */           this.bidderroleidset.add(Long.valueOf(_v_));
/*  221 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  225 */           this.maxbidprice = _input_.readInt64();
/*  226 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  230 */           this.bidderroleid = _input_.readInt64();
/*  231 */           break;
/*      */         
/*      */ 
/*      */         case 42: 
/*  235 */           this.bidderrolename = _input_.readBytes().toString("UTF-16LE");
/*  236 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  240 */           this.bidendtimestamp = _input_.readInt64();
/*  241 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  245 */           this.bidendfinaltimestamp = _input_.readInt64();
/*  246 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  250 */           this.issend = _input_.readInt32();
/*  251 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  255 */           this.bidendsessionid = _input_.readInt64();
/*  256 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  260 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  262 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  271 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  275 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  277 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AucItemInfo copy()
/*      */   {
/*  283 */     _xdb_verify_unsafe_();
/*  284 */     return new AucItemInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AucItemInfo toData()
/*      */   {
/*  290 */     _xdb_verify_unsafe_();
/*  291 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.AucItemInfo toBean()
/*      */   {
/*  296 */     _xdb_verify_unsafe_();
/*  297 */     return new AucItemInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AucItemInfo toDataIf()
/*      */   {
/*  303 */     _xdb_verify_unsafe_();
/*  304 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.AucItemInfo toBeanIf()
/*      */   {
/*  309 */     _xdb_verify_unsafe_();
/*  310 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  316 */     _xdb_verify_unsafe_();
/*  317 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getItemcfgid()
/*      */   {
/*  324 */     _xdb_verify_unsafe_();
/*  325 */     return this.itemcfgid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getBidderroleidset()
/*      */   {
/*  332 */     _xdb_verify_unsafe_();
/*  333 */     return Logs.logSet(new LogKey(this, "bidderroleidset"), this.bidderroleidset);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getBidderroleidsetAsData()
/*      */   {
/*  339 */     _xdb_verify_unsafe_();
/*      */     
/*  341 */     AucItemInfo _o_ = this;
/*  342 */     Set<Long> bidderroleidset = new SetX();
/*  343 */     bidderroleidset.addAll(_o_.bidderroleidset);
/*  344 */     return bidderroleidset;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getMaxbidprice()
/*      */   {
/*  351 */     _xdb_verify_unsafe_();
/*  352 */     return this.maxbidprice;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getBidderroleid()
/*      */   {
/*  359 */     _xdb_verify_unsafe_();
/*  360 */     return this.bidderroleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getBidderrolename()
/*      */   {
/*  367 */     _xdb_verify_unsafe_();
/*  368 */     return this.bidderrolename;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getBidderrolenameOctets()
/*      */   {
/*  375 */     _xdb_verify_unsafe_();
/*  376 */     return Octets.wrap(getBidderrolename(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getBidendtimestamp()
/*      */   {
/*  383 */     _xdb_verify_unsafe_();
/*  384 */     return this.bidendtimestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getBidendfinaltimestamp()
/*      */   {
/*  391 */     _xdb_verify_unsafe_();
/*  392 */     return this.bidendfinaltimestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getIssend()
/*      */   {
/*  399 */     _xdb_verify_unsafe_();
/*  400 */     return this.issend;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getBidendsessionid()
/*      */   {
/*  407 */     _xdb_verify_unsafe_();
/*  408 */     return this.bidendsessionid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setItemcfgid(int _v_)
/*      */   {
/*  415 */     _xdb_verify_unsafe_();
/*  416 */     Logs.logIf(new LogKey(this, "itemcfgid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  420 */         new xdb.logs.LogInt(this, AucItemInfo.this.itemcfgid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  424 */             AucItemInfo.this.itemcfgid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  428 */     });
/*  429 */     this.itemcfgid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMaxbidprice(long _v_)
/*      */   {
/*  436 */     _xdb_verify_unsafe_();
/*  437 */     Logs.logIf(new LogKey(this, "maxbidprice")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  441 */         new LogLong(this, AucItemInfo.this.maxbidprice)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  445 */             AucItemInfo.this.maxbidprice = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  449 */     });
/*  450 */     this.maxbidprice = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBidderroleid(long _v_)
/*      */   {
/*  457 */     _xdb_verify_unsafe_();
/*  458 */     Logs.logIf(new LogKey(this, "bidderroleid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  462 */         new LogLong(this, AucItemInfo.this.bidderroleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  466 */             AucItemInfo.this.bidderroleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  470 */     });
/*  471 */     this.bidderroleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBidderrolename(String _v_)
/*      */   {
/*  478 */     _xdb_verify_unsafe_();
/*  479 */     if (null == _v_)
/*  480 */       throw new NullPointerException();
/*  481 */     Logs.logIf(new LogKey(this, "bidderrolename")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  485 */         new xdb.logs.LogString(this, AucItemInfo.this.bidderrolename)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  489 */             AucItemInfo.this.bidderrolename = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  493 */     });
/*  494 */     this.bidderrolename = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBidderrolenameOctets(Octets _v_)
/*      */   {
/*  501 */     _xdb_verify_unsafe_();
/*  502 */     setBidderrolename(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBidendtimestamp(long _v_)
/*      */   {
/*  509 */     _xdb_verify_unsafe_();
/*  510 */     Logs.logIf(new LogKey(this, "bidendtimestamp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  514 */         new LogLong(this, AucItemInfo.this.bidendtimestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  518 */             AucItemInfo.this.bidendtimestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  522 */     });
/*  523 */     this.bidendtimestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBidendfinaltimestamp(long _v_)
/*      */   {
/*  530 */     _xdb_verify_unsafe_();
/*  531 */     Logs.logIf(new LogKey(this, "bidendfinaltimestamp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  535 */         new LogLong(this, AucItemInfo.this.bidendfinaltimestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  539 */             AucItemInfo.this.bidendfinaltimestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  543 */     });
/*  544 */     this.bidendfinaltimestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIssend(int _v_)
/*      */   {
/*  551 */     _xdb_verify_unsafe_();
/*  552 */     Logs.logIf(new LogKey(this, "issend")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  556 */         new xdb.logs.LogInt(this, AucItemInfo.this.issend)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  560 */             AucItemInfo.this.issend = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  564 */     });
/*  565 */     this.issend = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBidendsessionid(long _v_)
/*      */   {
/*  572 */     _xdb_verify_unsafe_();
/*  573 */     Logs.logIf(new LogKey(this, "bidendsessionid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  577 */         new LogLong(this, AucItemInfo.this.bidendsessionid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  581 */             AucItemInfo.this.bidendsessionid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  585 */     });
/*  586 */     this.bidendsessionid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  592 */     _xdb_verify_unsafe_();
/*  593 */     AucItemInfo _o_ = null;
/*  594 */     if ((_o1_ instanceof AucItemInfo)) { _o_ = (AucItemInfo)_o1_;
/*  595 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  596 */       return false;
/*  597 */     if (this.itemcfgid != _o_.itemcfgid) return false;
/*  598 */     if (!this.bidderroleidset.equals(_o_.bidderroleidset)) return false;
/*  599 */     if (this.maxbidprice != _o_.maxbidprice) return false;
/*  600 */     if (this.bidderroleid != _o_.bidderroleid) return false;
/*  601 */     if (!this.bidderrolename.equals(_o_.bidderrolename)) return false;
/*  602 */     if (this.bidendtimestamp != _o_.bidendtimestamp) return false;
/*  603 */     if (this.bidendfinaltimestamp != _o_.bidendfinaltimestamp) return false;
/*  604 */     if (this.issend != _o_.issend) return false;
/*  605 */     if (this.bidendsessionid != _o_.bidendsessionid) return false;
/*  606 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  612 */     _xdb_verify_unsafe_();
/*  613 */     int _h_ = 0;
/*  614 */     _h_ += this.itemcfgid;
/*  615 */     _h_ += this.bidderroleidset.hashCode();
/*  616 */     _h_ = (int)(_h_ + this.maxbidprice);
/*  617 */     _h_ = (int)(_h_ + this.bidderroleid);
/*  618 */     _h_ += this.bidderrolename.hashCode();
/*  619 */     _h_ = (int)(_h_ + this.bidendtimestamp);
/*  620 */     _h_ = (int)(_h_ + this.bidendfinaltimestamp);
/*  621 */     _h_ += this.issend;
/*  622 */     _h_ = (int)(_h_ + this.bidendsessionid);
/*  623 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  629 */     _xdb_verify_unsafe_();
/*  630 */     StringBuilder _sb_ = new StringBuilder();
/*  631 */     _sb_.append("(");
/*  632 */     _sb_.append(this.itemcfgid);
/*  633 */     _sb_.append(",");
/*  634 */     _sb_.append(this.bidderroleidset);
/*  635 */     _sb_.append(",");
/*  636 */     _sb_.append(this.maxbidprice);
/*  637 */     _sb_.append(",");
/*  638 */     _sb_.append(this.bidderroleid);
/*  639 */     _sb_.append(",");
/*  640 */     _sb_.append("'").append(this.bidderrolename).append("'");
/*  641 */     _sb_.append(",");
/*  642 */     _sb_.append(this.bidendtimestamp);
/*  643 */     _sb_.append(",");
/*  644 */     _sb_.append(this.bidendfinaltimestamp);
/*  645 */     _sb_.append(",");
/*  646 */     _sb_.append(this.issend);
/*  647 */     _sb_.append(",");
/*  648 */     _sb_.append(this.bidendsessionid);
/*  649 */     _sb_.append(")");
/*  650 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  656 */     ListenableBean lb = new ListenableBean();
/*  657 */     lb.add(new ListenableChanged().setVarName("itemcfgid"));
/*  658 */     lb.add(new xdb.logs.ListenableSet().setVarName("bidderroleidset"));
/*  659 */     lb.add(new ListenableChanged().setVarName("maxbidprice"));
/*  660 */     lb.add(new ListenableChanged().setVarName("bidderroleid"));
/*  661 */     lb.add(new ListenableChanged().setVarName("bidderrolename"));
/*  662 */     lb.add(new ListenableChanged().setVarName("bidendtimestamp"));
/*  663 */     lb.add(new ListenableChanged().setVarName("bidendfinaltimestamp"));
/*  664 */     lb.add(new ListenableChanged().setVarName("issend"));
/*  665 */     lb.add(new ListenableChanged().setVarName("bidendsessionid"));
/*  666 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.AucItemInfo {
/*      */     private Const() {}
/*      */     
/*      */     AucItemInfo nThis() {
/*  673 */       return AucItemInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  679 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AucItemInfo copy()
/*      */     {
/*  685 */       return AucItemInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AucItemInfo toData()
/*      */     {
/*  691 */       return AucItemInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.AucItemInfo toBean()
/*      */     {
/*  696 */       return AucItemInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AucItemInfo toDataIf()
/*      */     {
/*  702 */       return AucItemInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.AucItemInfo toBeanIf()
/*      */     {
/*  707 */       return AucItemInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItemcfgid()
/*      */     {
/*  714 */       AucItemInfo.this._xdb_verify_unsafe_();
/*  715 */       return AucItemInfo.this.itemcfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getBidderroleidset()
/*      */     {
/*  722 */       AucItemInfo.this._xdb_verify_unsafe_();
/*  723 */       return xdb.Consts.constSet(AucItemInfo.this.bidderroleidset);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getBidderroleidsetAsData()
/*      */     {
/*  729 */       AucItemInfo.this._xdb_verify_unsafe_();
/*      */       
/*  731 */       AucItemInfo _o_ = AucItemInfo.this;
/*  732 */       Set<Long> bidderroleidset = new SetX();
/*  733 */       bidderroleidset.addAll(_o_.bidderroleidset);
/*  734 */       return bidderroleidset;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMaxbidprice()
/*      */     {
/*  741 */       AucItemInfo.this._xdb_verify_unsafe_();
/*  742 */       return AucItemInfo.this.maxbidprice;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBidderroleid()
/*      */     {
/*  749 */       AucItemInfo.this._xdb_verify_unsafe_();
/*  750 */       return AucItemInfo.this.bidderroleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getBidderrolename()
/*      */     {
/*  757 */       AucItemInfo.this._xdb_verify_unsafe_();
/*  758 */       return AucItemInfo.this.bidderrolename;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getBidderrolenameOctets()
/*      */     {
/*  765 */       AucItemInfo.this._xdb_verify_unsafe_();
/*  766 */       return AucItemInfo.this.getBidderrolenameOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBidendtimestamp()
/*      */     {
/*  773 */       AucItemInfo.this._xdb_verify_unsafe_();
/*  774 */       return AucItemInfo.this.bidendtimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBidendfinaltimestamp()
/*      */     {
/*  781 */       AucItemInfo.this._xdb_verify_unsafe_();
/*  782 */       return AucItemInfo.this.bidendfinaltimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getIssend()
/*      */     {
/*  789 */       AucItemInfo.this._xdb_verify_unsafe_();
/*  790 */       return AucItemInfo.this.issend;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBidendsessionid()
/*      */     {
/*  797 */       AucItemInfo.this._xdb_verify_unsafe_();
/*  798 */       return AucItemInfo.this.bidendsessionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItemcfgid(int _v_)
/*      */     {
/*  805 */       AucItemInfo.this._xdb_verify_unsafe_();
/*  806 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMaxbidprice(long _v_)
/*      */     {
/*  813 */       AucItemInfo.this._xdb_verify_unsafe_();
/*  814 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBidderroleid(long _v_)
/*      */     {
/*  821 */       AucItemInfo.this._xdb_verify_unsafe_();
/*  822 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBidderrolename(String _v_)
/*      */     {
/*  829 */       AucItemInfo.this._xdb_verify_unsafe_();
/*  830 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBidderrolenameOctets(Octets _v_)
/*      */     {
/*  837 */       AucItemInfo.this._xdb_verify_unsafe_();
/*  838 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBidendtimestamp(long _v_)
/*      */     {
/*  845 */       AucItemInfo.this._xdb_verify_unsafe_();
/*  846 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBidendfinaltimestamp(long _v_)
/*      */     {
/*  853 */       AucItemInfo.this._xdb_verify_unsafe_();
/*  854 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIssend(int _v_)
/*      */     {
/*  861 */       AucItemInfo.this._xdb_verify_unsafe_();
/*  862 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBidendsessionid(long _v_)
/*      */     {
/*  869 */       AucItemInfo.this._xdb_verify_unsafe_();
/*  870 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  876 */       AucItemInfo.this._xdb_verify_unsafe_();
/*  877 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  883 */       AucItemInfo.this._xdb_verify_unsafe_();
/*  884 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  890 */       return AucItemInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  896 */       return AucItemInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  902 */       AucItemInfo.this._xdb_verify_unsafe_();
/*  903 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  909 */       return AucItemInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  915 */       return AucItemInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  921 */       AucItemInfo.this._xdb_verify_unsafe_();
/*  922 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  928 */       return AucItemInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  934 */       return AucItemInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  940 */       return AucItemInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  946 */       return AucItemInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  952 */       return AucItemInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  958 */       return AucItemInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  964 */       return AucItemInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.AucItemInfo
/*      */   {
/*      */     private int itemcfgid;
/*      */     
/*      */     private HashSet<Long> bidderroleidset;
/*      */     
/*      */     private long maxbidprice;
/*      */     
/*      */     private long bidderroleid;
/*      */     
/*      */     private String bidderrolename;
/*      */     
/*      */     private long bidendtimestamp;
/*      */     
/*      */     private long bidendfinaltimestamp;
/*      */     
/*      */     private int issend;
/*      */     
/*      */     private long bidendsessionid;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  992 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  997 */       this.bidderroleidset = new HashSet();
/*  998 */       this.bidderrolename = "";
/*      */     }
/*      */     
/*      */     Data(xbean.AucItemInfo _o1_)
/*      */     {
/* 1003 */       if ((_o1_ instanceof AucItemInfo)) { assign((AucItemInfo)_o1_);
/* 1004 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1005 */       } else if ((_o1_ instanceof AucItemInfo.Const)) assign(((AucItemInfo.Const)_o1_).nThis()); else {
/* 1006 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(AucItemInfo _o_) {
/* 1011 */       this.itemcfgid = _o_.itemcfgid;
/* 1012 */       this.bidderroleidset = new HashSet();
/* 1013 */       this.bidderroleidset.addAll(_o_.bidderroleidset);
/* 1014 */       this.maxbidprice = _o_.maxbidprice;
/* 1015 */       this.bidderroleid = _o_.bidderroleid;
/* 1016 */       this.bidderrolename = _o_.bidderrolename;
/* 1017 */       this.bidendtimestamp = _o_.bidendtimestamp;
/* 1018 */       this.bidendfinaltimestamp = _o_.bidendfinaltimestamp;
/* 1019 */       this.issend = _o_.issend;
/* 1020 */       this.bidendsessionid = _o_.bidendsessionid;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1025 */       this.itemcfgid = _o_.itemcfgid;
/* 1026 */       this.bidderroleidset = new HashSet();
/* 1027 */       this.bidderroleidset.addAll(_o_.bidderroleidset);
/* 1028 */       this.maxbidprice = _o_.maxbidprice;
/* 1029 */       this.bidderroleid = _o_.bidderroleid;
/* 1030 */       this.bidderrolename = _o_.bidderrolename;
/* 1031 */       this.bidendtimestamp = _o_.bidendtimestamp;
/* 1032 */       this.bidendfinaltimestamp = _o_.bidendfinaltimestamp;
/* 1033 */       this.issend = _o_.issend;
/* 1034 */       this.bidendsessionid = _o_.bidendsessionid;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1040 */       _os_.marshal(this.itemcfgid);
/* 1041 */       _os_.compact_uint32(this.bidderroleidset.size());
/* 1042 */       for (Long _v_ : this.bidderroleidset)
/*      */       {
/* 1044 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 1046 */       _os_.marshal(this.maxbidprice);
/* 1047 */       _os_.marshal(this.bidderroleid);
/* 1048 */       _os_.marshal(this.bidderrolename, "UTF-16LE");
/* 1049 */       _os_.marshal(this.bidendtimestamp);
/* 1050 */       _os_.marshal(this.bidendfinaltimestamp);
/* 1051 */       _os_.marshal(this.issend);
/* 1052 */       _os_.marshal(this.bidendsessionid);
/* 1053 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1059 */       this.itemcfgid = _os_.unmarshal_int();
/* 1060 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1062 */         long _v_ = 0L;
/* 1063 */         _v_ = _os_.unmarshal_long();
/* 1064 */         this.bidderroleidset.add(Long.valueOf(_v_));
/*      */       }
/* 1066 */       this.maxbidprice = _os_.unmarshal_long();
/* 1067 */       this.bidderroleid = _os_.unmarshal_long();
/* 1068 */       this.bidderrolename = _os_.unmarshal_String("UTF-16LE");
/* 1069 */       this.bidendtimestamp = _os_.unmarshal_long();
/* 1070 */       this.bidendfinaltimestamp = _os_.unmarshal_long();
/* 1071 */       this.issend = _os_.unmarshal_int();
/* 1072 */       this.bidendsessionid = _os_.unmarshal_long();
/* 1073 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1079 */       int _size_ = 0;
/* 1080 */       _size_ += CodedOutputStream.computeInt32Size(1, this.itemcfgid);
/* 1081 */       for (Long _v_ : this.bidderroleidset)
/*      */       {
/* 1083 */         _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*      */       }
/* 1085 */       _size_ += CodedOutputStream.computeInt64Size(3, this.maxbidprice);
/* 1086 */       _size_ += CodedOutputStream.computeInt64Size(4, this.bidderroleid);
/*      */       try
/*      */       {
/* 1089 */         _size_ += CodedOutputStream.computeBytesSize(5, ppbio.ByteString.copyFrom(this.bidderrolename, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/* 1093 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 1095 */       _size_ += CodedOutputStream.computeInt64Size(6, this.bidendtimestamp);
/* 1096 */       _size_ += CodedOutputStream.computeInt64Size(7, this.bidendfinaltimestamp);
/* 1097 */       _size_ += CodedOutputStream.computeInt32Size(8, this.issend);
/* 1098 */       _size_ += CodedOutputStream.computeInt64Size(9, this.bidendsessionid);
/* 1099 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1107 */         _output_.writeInt32(1, this.itemcfgid);
/* 1108 */         for (Long _v_ : this.bidderroleidset)
/*      */         {
/* 1110 */           _output_.writeInt64(2, _v_.longValue());
/*      */         }
/* 1112 */         _output_.writeInt64(3, this.maxbidprice);
/* 1113 */         _output_.writeInt64(4, this.bidderroleid);
/* 1114 */         _output_.writeBytes(5, ppbio.ByteString.copyFrom(this.bidderrolename, "UTF-16LE"));
/* 1115 */         _output_.writeInt64(6, this.bidendtimestamp);
/* 1116 */         _output_.writeInt64(7, this.bidendfinaltimestamp);
/* 1117 */         _output_.writeInt32(8, this.issend);
/* 1118 */         _output_.writeInt64(9, this.bidendsessionid);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1122 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1124 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1132 */         boolean done = false;
/* 1133 */         while (!done)
/*      */         {
/* 1135 */           int tag = _input_.readTag();
/* 1136 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1140 */             done = true;
/* 1141 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1145 */             this.itemcfgid = _input_.readInt32();
/* 1146 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1150 */             long _v_ = 0L;
/* 1151 */             _v_ = _input_.readInt64();
/* 1152 */             this.bidderroleidset.add(Long.valueOf(_v_));
/* 1153 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1157 */             this.maxbidprice = _input_.readInt64();
/* 1158 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1162 */             this.bidderroleid = _input_.readInt64();
/* 1163 */             break;
/*      */           
/*      */ 
/*      */           case 42: 
/* 1167 */             this.bidderrolename = _input_.readBytes().toString("UTF-16LE");
/* 1168 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1172 */             this.bidendtimestamp = _input_.readInt64();
/* 1173 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1177 */             this.bidendfinaltimestamp = _input_.readInt64();
/* 1178 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1182 */             this.issend = _input_.readInt32();
/* 1183 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1187 */             this.bidendsessionid = _input_.readInt64();
/* 1188 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1192 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1194 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1203 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1207 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1209 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AucItemInfo copy()
/*      */     {
/* 1215 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AucItemInfo toData()
/*      */     {
/* 1221 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.AucItemInfo toBean()
/*      */     {
/* 1226 */       return new AucItemInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AucItemInfo toDataIf()
/*      */     {
/* 1232 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.AucItemInfo toBeanIf()
/*      */     {
/* 1237 */       return new AucItemInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1243 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1247 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1251 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1255 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1259 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1263 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1267 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItemcfgid()
/*      */     {
/* 1274 */       return this.itemcfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getBidderroleidset()
/*      */     {
/* 1281 */       return this.bidderroleidset;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getBidderroleidsetAsData()
/*      */     {
/* 1288 */       return this.bidderroleidset;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMaxbidprice()
/*      */     {
/* 1295 */       return this.maxbidprice;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBidderroleid()
/*      */     {
/* 1302 */       return this.bidderroleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getBidderrolename()
/*      */     {
/* 1309 */       return this.bidderrolename;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getBidderrolenameOctets()
/*      */     {
/* 1316 */       return Octets.wrap(getBidderrolename(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBidendtimestamp()
/*      */     {
/* 1323 */       return this.bidendtimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBidendfinaltimestamp()
/*      */     {
/* 1330 */       return this.bidendfinaltimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getIssend()
/*      */     {
/* 1337 */       return this.issend;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBidendsessionid()
/*      */     {
/* 1344 */       return this.bidendsessionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItemcfgid(int _v_)
/*      */     {
/* 1351 */       this.itemcfgid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMaxbidprice(long _v_)
/*      */     {
/* 1358 */       this.maxbidprice = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBidderroleid(long _v_)
/*      */     {
/* 1365 */       this.bidderroleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBidderrolename(String _v_)
/*      */     {
/* 1372 */       if (null == _v_)
/* 1373 */         throw new NullPointerException();
/* 1374 */       this.bidderrolename = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBidderrolenameOctets(Octets _v_)
/*      */     {
/* 1381 */       setBidderrolename(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBidendtimestamp(long _v_)
/*      */     {
/* 1388 */       this.bidendtimestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBidendfinaltimestamp(long _v_)
/*      */     {
/* 1395 */       this.bidendfinaltimestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIssend(int _v_)
/*      */     {
/* 1402 */       this.issend = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBidendsessionid(long _v_)
/*      */     {
/* 1409 */       this.bidendsessionid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1415 */       if (!(_o1_ instanceof Data)) return false;
/* 1416 */       Data _o_ = (Data)_o1_;
/* 1417 */       if (this.itemcfgid != _o_.itemcfgid) return false;
/* 1418 */       if (!this.bidderroleidset.equals(_o_.bidderroleidset)) return false;
/* 1419 */       if (this.maxbidprice != _o_.maxbidprice) return false;
/* 1420 */       if (this.bidderroleid != _o_.bidderroleid) return false;
/* 1421 */       if (!this.bidderrolename.equals(_o_.bidderrolename)) return false;
/* 1422 */       if (this.bidendtimestamp != _o_.bidendtimestamp) return false;
/* 1423 */       if (this.bidendfinaltimestamp != _o_.bidendfinaltimestamp) return false;
/* 1424 */       if (this.issend != _o_.issend) return false;
/* 1425 */       if (this.bidendsessionid != _o_.bidendsessionid) return false;
/* 1426 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1432 */       int _h_ = 0;
/* 1433 */       _h_ += this.itemcfgid;
/* 1434 */       _h_ += this.bidderroleidset.hashCode();
/* 1435 */       _h_ = (int)(_h_ + this.maxbidprice);
/* 1436 */       _h_ = (int)(_h_ + this.bidderroleid);
/* 1437 */       _h_ += this.bidderrolename.hashCode();
/* 1438 */       _h_ = (int)(_h_ + this.bidendtimestamp);
/* 1439 */       _h_ = (int)(_h_ + this.bidendfinaltimestamp);
/* 1440 */       _h_ += this.issend;
/* 1441 */       _h_ = (int)(_h_ + this.bidendsessionid);
/* 1442 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1448 */       StringBuilder _sb_ = new StringBuilder();
/* 1449 */       _sb_.append("(");
/* 1450 */       _sb_.append(this.itemcfgid);
/* 1451 */       _sb_.append(",");
/* 1452 */       _sb_.append(this.bidderroleidset);
/* 1453 */       _sb_.append(",");
/* 1454 */       _sb_.append(this.maxbidprice);
/* 1455 */       _sb_.append(",");
/* 1456 */       _sb_.append(this.bidderroleid);
/* 1457 */       _sb_.append(",");
/* 1458 */       _sb_.append("'").append(this.bidderrolename).append("'");
/* 1459 */       _sb_.append(",");
/* 1460 */       _sb_.append(this.bidendtimestamp);
/* 1461 */       _sb_.append(",");
/* 1462 */       _sb_.append(this.bidendfinaltimestamp);
/* 1463 */       _sb_.append(",");
/* 1464 */       _sb_.append(this.issend);
/* 1465 */       _sb_.append(",");
/* 1466 */       _sb_.append(this.bidendsessionid);
/* 1467 */       _sb_.append(")");
/* 1468 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\AucItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */