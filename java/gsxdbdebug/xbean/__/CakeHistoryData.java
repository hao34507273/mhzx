/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import ppbio.ByteString;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class CakeHistoryData extends XBean implements xbean.CakeHistoryData
/*      */ {
/*      */   private long timeline;
/*      */   private int beforecakeid;
/*      */   private int aftercakeid;
/*      */   private String operrolename;
/*      */   private String mastername;
/*      */   private int itemid;
/*      */   private int historytype;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.timeline = 0L;
/*   31 */     this.beforecakeid = 0;
/*   32 */     this.aftercakeid = 0;
/*   33 */     this.operrolename = "";
/*   34 */     this.mastername = "";
/*   35 */     this.itemid = 0;
/*   36 */     this.historytype = 0;
/*      */   }
/*      */   
/*      */   CakeHistoryData(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.operrolename = "";
/*   43 */     this.mastername = "";
/*      */   }
/*      */   
/*      */   public CakeHistoryData()
/*      */   {
/*   48 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public CakeHistoryData(CakeHistoryData _o_)
/*      */   {
/*   53 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   CakeHistoryData(xbean.CakeHistoryData _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   58 */     super(_xp_, _vn_);
/*   59 */     if ((_o1_ instanceof CakeHistoryData)) { assign((CakeHistoryData)_o1_);
/*   60 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   61 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   62 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(CakeHistoryData _o_) {
/*   67 */     _o_._xdb_verify_unsafe_();
/*   68 */     this.timeline = _o_.timeline;
/*   69 */     this.beforecakeid = _o_.beforecakeid;
/*   70 */     this.aftercakeid = _o_.aftercakeid;
/*   71 */     this.operrolename = _o_.operrolename;
/*   72 */     this.mastername = _o_.mastername;
/*   73 */     this.itemid = _o_.itemid;
/*   74 */     this.historytype = _o_.historytype;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   79 */     this.timeline = _o_.timeline;
/*   80 */     this.beforecakeid = _o_.beforecakeid;
/*   81 */     this.aftercakeid = _o_.aftercakeid;
/*   82 */     this.operrolename = _o_.operrolename;
/*   83 */     this.mastername = _o_.mastername;
/*   84 */     this.itemid = _o_.itemid;
/*   85 */     this.historytype = _o_.historytype;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   91 */     _xdb_verify_unsafe_();
/*   92 */     _os_.marshal(this.timeline);
/*   93 */     _os_.marshal(this.beforecakeid);
/*   94 */     _os_.marshal(this.aftercakeid);
/*   95 */     _os_.marshal(this.operrolename, "UTF-16LE");
/*   96 */     _os_.marshal(this.mastername, "UTF-16LE");
/*   97 */     _os_.marshal(this.itemid);
/*   98 */     _os_.marshal(this.historytype);
/*   99 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  105 */     _xdb_verify_unsafe_();
/*  106 */     this.timeline = _os_.unmarshal_long();
/*  107 */     this.beforecakeid = _os_.unmarshal_int();
/*  108 */     this.aftercakeid = _os_.unmarshal_int();
/*  109 */     this.operrolename = _os_.unmarshal_String("UTF-16LE");
/*  110 */     this.mastername = _os_.unmarshal_String("UTF-16LE");
/*  111 */     this.itemid = _os_.unmarshal_int();
/*  112 */     this.historytype = _os_.unmarshal_int();
/*  113 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  119 */     _xdb_verify_unsafe_();
/*  120 */     int _size_ = 0;
/*  121 */     _size_ += CodedOutputStream.computeInt64Size(1, this.timeline);
/*  122 */     _size_ += CodedOutputStream.computeInt32Size(2, this.beforecakeid);
/*  123 */     _size_ += CodedOutputStream.computeInt32Size(3, this.aftercakeid);
/*      */     try
/*      */     {
/*  126 */       _size_ += CodedOutputStream.computeBytesSize(4, ByteString.copyFrom(this.operrolename, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  130 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*      */     try
/*      */     {
/*  134 */       _size_ += CodedOutputStream.computeBytesSize(5, ByteString.copyFrom(this.mastername, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  138 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  140 */     _size_ += CodedOutputStream.computeInt32Size(6, this.itemid);
/*  141 */     _size_ += CodedOutputStream.computeInt32Size(7, this.historytype);
/*  142 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  148 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  151 */       _output_.writeInt64(1, this.timeline);
/*  152 */       _output_.writeInt32(2, this.beforecakeid);
/*  153 */       _output_.writeInt32(3, this.aftercakeid);
/*  154 */       _output_.writeBytes(4, ByteString.copyFrom(this.operrolename, "UTF-16LE"));
/*  155 */       _output_.writeBytes(5, ByteString.copyFrom(this.mastername, "UTF-16LE"));
/*  156 */       _output_.writeInt32(6, this.itemid);
/*  157 */       _output_.writeInt32(7, this.historytype);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  161 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  163 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  169 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  172 */       boolean done = false;
/*  173 */       while (!done)
/*      */       {
/*  175 */         int tag = _input_.readTag();
/*  176 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  180 */           done = true;
/*  181 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  185 */           this.timeline = _input_.readInt64();
/*  186 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  190 */           this.beforecakeid = _input_.readInt32();
/*  191 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  195 */           this.aftercakeid = _input_.readInt32();
/*  196 */           break;
/*      */         
/*      */ 
/*      */         case 34: 
/*  200 */           this.operrolename = _input_.readBytes().toString("UTF-16LE");
/*  201 */           break;
/*      */         
/*      */ 
/*      */         case 42: 
/*  205 */           this.mastername = _input_.readBytes().toString("UTF-16LE");
/*  206 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  210 */           this.itemid = _input_.readInt32();
/*  211 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  215 */           this.historytype = _input_.readInt32();
/*  216 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  220 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  222 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  231 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  235 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  237 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CakeHistoryData copy()
/*      */   {
/*  243 */     _xdb_verify_unsafe_();
/*  244 */     return new CakeHistoryData(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CakeHistoryData toData()
/*      */   {
/*  250 */     _xdb_verify_unsafe_();
/*  251 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CakeHistoryData toBean()
/*      */   {
/*  256 */     _xdb_verify_unsafe_();
/*  257 */     return new CakeHistoryData(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CakeHistoryData toDataIf()
/*      */   {
/*  263 */     _xdb_verify_unsafe_();
/*  264 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CakeHistoryData toBeanIf()
/*      */   {
/*  269 */     _xdb_verify_unsafe_();
/*  270 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  276 */     _xdb_verify_unsafe_();
/*  277 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getTimeline()
/*      */   {
/*  284 */     _xdb_verify_unsafe_();
/*  285 */     return this.timeline;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getBeforecakeid()
/*      */   {
/*  292 */     _xdb_verify_unsafe_();
/*  293 */     return this.beforecakeid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAftercakeid()
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*  301 */     return this.aftercakeid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getOperrolename()
/*      */   {
/*  308 */     _xdb_verify_unsafe_();
/*  309 */     return this.operrolename;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getOperrolenameOctets()
/*      */   {
/*  316 */     _xdb_verify_unsafe_();
/*  317 */     return Octets.wrap(getOperrolename(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getMastername()
/*      */   {
/*  324 */     _xdb_verify_unsafe_();
/*  325 */     return this.mastername;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getMasternameOctets()
/*      */   {
/*  332 */     _xdb_verify_unsafe_();
/*  333 */     return Octets.wrap(getMastername(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getItemid()
/*      */   {
/*  340 */     _xdb_verify_unsafe_();
/*  341 */     return this.itemid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getHistorytype()
/*      */   {
/*  348 */     _xdb_verify_unsafe_();
/*  349 */     return this.historytype;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTimeline(long _v_)
/*      */   {
/*  356 */     _xdb_verify_unsafe_();
/*  357 */     xdb.Logs.logIf(new LogKey(this, "timeline")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  361 */         new xdb.logs.LogLong(this, CakeHistoryData.this.timeline)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  365 */             CakeHistoryData.this.timeline = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  369 */     });
/*  370 */     this.timeline = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBeforecakeid(int _v_)
/*      */   {
/*  377 */     _xdb_verify_unsafe_();
/*  378 */     xdb.Logs.logIf(new LogKey(this, "beforecakeid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  382 */         new LogInt(this, CakeHistoryData.this.beforecakeid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  386 */             CakeHistoryData.this.beforecakeid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  390 */     });
/*  391 */     this.beforecakeid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAftercakeid(int _v_)
/*      */   {
/*  398 */     _xdb_verify_unsafe_();
/*  399 */     xdb.Logs.logIf(new LogKey(this, "aftercakeid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  403 */         new LogInt(this, CakeHistoryData.this.aftercakeid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  407 */             CakeHistoryData.this.aftercakeid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  411 */     });
/*  412 */     this.aftercakeid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOperrolename(String _v_)
/*      */   {
/*  419 */     _xdb_verify_unsafe_();
/*  420 */     if (null == _v_)
/*  421 */       throw new NullPointerException();
/*  422 */     xdb.Logs.logIf(new LogKey(this, "operrolename")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  426 */         new xdb.logs.LogString(this, CakeHistoryData.this.operrolename)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  430 */             CakeHistoryData.this.operrolename = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  434 */     });
/*  435 */     this.operrolename = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOperrolenameOctets(Octets _v_)
/*      */   {
/*  442 */     _xdb_verify_unsafe_();
/*  443 */     setOperrolename(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMastername(String _v_)
/*      */   {
/*  450 */     _xdb_verify_unsafe_();
/*  451 */     if (null == _v_)
/*  452 */       throw new NullPointerException();
/*  453 */     xdb.Logs.logIf(new LogKey(this, "mastername")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  457 */         new xdb.logs.LogString(this, CakeHistoryData.this.mastername)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  461 */             CakeHistoryData.this.mastername = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  465 */     });
/*  466 */     this.mastername = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMasternameOctets(Octets _v_)
/*      */   {
/*  473 */     _xdb_verify_unsafe_();
/*  474 */     setMastername(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setItemid(int _v_)
/*      */   {
/*  481 */     _xdb_verify_unsafe_();
/*  482 */     xdb.Logs.logIf(new LogKey(this, "itemid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  486 */         new LogInt(this, CakeHistoryData.this.itemid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  490 */             CakeHistoryData.this.itemid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  494 */     });
/*  495 */     this.itemid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHistorytype(int _v_)
/*      */   {
/*  502 */     _xdb_verify_unsafe_();
/*  503 */     xdb.Logs.logIf(new LogKey(this, "historytype")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  507 */         new LogInt(this, CakeHistoryData.this.historytype)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  511 */             CakeHistoryData.this.historytype = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  515 */     });
/*  516 */     this.historytype = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  522 */     _xdb_verify_unsafe_();
/*  523 */     CakeHistoryData _o_ = null;
/*  524 */     if ((_o1_ instanceof CakeHistoryData)) { _o_ = (CakeHistoryData)_o1_;
/*  525 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  526 */       return false;
/*  527 */     if (this.timeline != _o_.timeline) return false;
/*  528 */     if (this.beforecakeid != _o_.beforecakeid) return false;
/*  529 */     if (this.aftercakeid != _o_.aftercakeid) return false;
/*  530 */     if (!this.operrolename.equals(_o_.operrolename)) return false;
/*  531 */     if (!this.mastername.equals(_o_.mastername)) return false;
/*  532 */     if (this.itemid != _o_.itemid) return false;
/*  533 */     if (this.historytype != _o_.historytype) return false;
/*  534 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  540 */     _xdb_verify_unsafe_();
/*  541 */     int _h_ = 0;
/*  542 */     _h_ = (int)(_h_ + this.timeline);
/*  543 */     _h_ += this.beforecakeid;
/*  544 */     _h_ += this.aftercakeid;
/*  545 */     _h_ += this.operrolename.hashCode();
/*  546 */     _h_ += this.mastername.hashCode();
/*  547 */     _h_ += this.itemid;
/*  548 */     _h_ += this.historytype;
/*  549 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  555 */     _xdb_verify_unsafe_();
/*  556 */     StringBuilder _sb_ = new StringBuilder();
/*  557 */     _sb_.append("(");
/*  558 */     _sb_.append(this.timeline);
/*  559 */     _sb_.append(",");
/*  560 */     _sb_.append(this.beforecakeid);
/*  561 */     _sb_.append(",");
/*  562 */     _sb_.append(this.aftercakeid);
/*  563 */     _sb_.append(",");
/*  564 */     _sb_.append("'").append(this.operrolename).append("'");
/*  565 */     _sb_.append(",");
/*  566 */     _sb_.append("'").append(this.mastername).append("'");
/*  567 */     _sb_.append(",");
/*  568 */     _sb_.append(this.itemid);
/*  569 */     _sb_.append(",");
/*  570 */     _sb_.append(this.historytype);
/*  571 */     _sb_.append(")");
/*  572 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  578 */     ListenableBean lb = new ListenableBean();
/*  579 */     lb.add(new ListenableChanged().setVarName("timeline"));
/*  580 */     lb.add(new ListenableChanged().setVarName("beforecakeid"));
/*  581 */     lb.add(new ListenableChanged().setVarName("aftercakeid"));
/*  582 */     lb.add(new ListenableChanged().setVarName("operrolename"));
/*  583 */     lb.add(new ListenableChanged().setVarName("mastername"));
/*  584 */     lb.add(new ListenableChanged().setVarName("itemid"));
/*  585 */     lb.add(new ListenableChanged().setVarName("historytype"));
/*  586 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.CakeHistoryData {
/*      */     private Const() {}
/*      */     
/*      */     CakeHistoryData nThis() {
/*  593 */       return CakeHistoryData.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  599 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CakeHistoryData copy()
/*      */     {
/*  605 */       return CakeHistoryData.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CakeHistoryData toData()
/*      */     {
/*  611 */       return CakeHistoryData.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.CakeHistoryData toBean()
/*      */     {
/*  616 */       return CakeHistoryData.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CakeHistoryData toDataIf()
/*      */     {
/*  622 */       return CakeHistoryData.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.CakeHistoryData toBeanIf()
/*      */     {
/*  627 */       return CakeHistoryData.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTimeline()
/*      */     {
/*  634 */       CakeHistoryData.this._xdb_verify_unsafe_();
/*  635 */       return CakeHistoryData.this.timeline;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBeforecakeid()
/*      */     {
/*  642 */       CakeHistoryData.this._xdb_verify_unsafe_();
/*  643 */       return CakeHistoryData.this.beforecakeid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAftercakeid()
/*      */     {
/*  650 */       CakeHistoryData.this._xdb_verify_unsafe_();
/*  651 */       return CakeHistoryData.this.aftercakeid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getOperrolename()
/*      */     {
/*  658 */       CakeHistoryData.this._xdb_verify_unsafe_();
/*  659 */       return CakeHistoryData.this.operrolename;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getOperrolenameOctets()
/*      */     {
/*  666 */       CakeHistoryData.this._xdb_verify_unsafe_();
/*  667 */       return CakeHistoryData.this.getOperrolenameOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getMastername()
/*      */     {
/*  674 */       CakeHistoryData.this._xdb_verify_unsafe_();
/*  675 */       return CakeHistoryData.this.mastername;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getMasternameOctets()
/*      */     {
/*  682 */       CakeHistoryData.this._xdb_verify_unsafe_();
/*  683 */       return CakeHistoryData.this.getMasternameOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItemid()
/*      */     {
/*  690 */       CakeHistoryData.this._xdb_verify_unsafe_();
/*  691 */       return CakeHistoryData.this.itemid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHistorytype()
/*      */     {
/*  698 */       CakeHistoryData.this._xdb_verify_unsafe_();
/*  699 */       return CakeHistoryData.this.historytype;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTimeline(long _v_)
/*      */     {
/*  706 */       CakeHistoryData.this._xdb_verify_unsafe_();
/*  707 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBeforecakeid(int _v_)
/*      */     {
/*  714 */       CakeHistoryData.this._xdb_verify_unsafe_();
/*  715 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAftercakeid(int _v_)
/*      */     {
/*  722 */       CakeHistoryData.this._xdb_verify_unsafe_();
/*  723 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOperrolename(String _v_)
/*      */     {
/*  730 */       CakeHistoryData.this._xdb_verify_unsafe_();
/*  731 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOperrolenameOctets(Octets _v_)
/*      */     {
/*  738 */       CakeHistoryData.this._xdb_verify_unsafe_();
/*  739 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMastername(String _v_)
/*      */     {
/*  746 */       CakeHistoryData.this._xdb_verify_unsafe_();
/*  747 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMasternameOctets(Octets _v_)
/*      */     {
/*  754 */       CakeHistoryData.this._xdb_verify_unsafe_();
/*  755 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItemid(int _v_)
/*      */     {
/*  762 */       CakeHistoryData.this._xdb_verify_unsafe_();
/*  763 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHistorytype(int _v_)
/*      */     {
/*  770 */       CakeHistoryData.this._xdb_verify_unsafe_();
/*  771 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  777 */       CakeHistoryData.this._xdb_verify_unsafe_();
/*  778 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  784 */       CakeHistoryData.this._xdb_verify_unsafe_();
/*  785 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  791 */       return CakeHistoryData.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  797 */       return CakeHistoryData.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  803 */       CakeHistoryData.this._xdb_verify_unsafe_();
/*  804 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  810 */       return CakeHistoryData.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  816 */       return CakeHistoryData.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  822 */       CakeHistoryData.this._xdb_verify_unsafe_();
/*  823 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  829 */       return CakeHistoryData.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  835 */       return CakeHistoryData.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  841 */       return CakeHistoryData.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  847 */       return CakeHistoryData.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  853 */       return CakeHistoryData.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  859 */       return CakeHistoryData.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  865 */       return CakeHistoryData.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.CakeHistoryData
/*      */   {
/*      */     private long timeline;
/*      */     
/*      */     private int beforecakeid;
/*      */     
/*      */     private int aftercakeid;
/*      */     
/*      */     private String operrolename;
/*      */     
/*      */     private String mastername;
/*      */     
/*      */     private int itemid;
/*      */     
/*      */     private int historytype;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  889 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  894 */       this.operrolename = "";
/*  895 */       this.mastername = "";
/*      */     }
/*      */     
/*      */     Data(xbean.CakeHistoryData _o1_)
/*      */     {
/*  900 */       if ((_o1_ instanceof CakeHistoryData)) { assign((CakeHistoryData)_o1_);
/*  901 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  902 */       } else if ((_o1_ instanceof CakeHistoryData.Const)) assign(((CakeHistoryData.Const)_o1_).nThis()); else {
/*  903 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(CakeHistoryData _o_) {
/*  908 */       this.timeline = _o_.timeline;
/*  909 */       this.beforecakeid = _o_.beforecakeid;
/*  910 */       this.aftercakeid = _o_.aftercakeid;
/*  911 */       this.operrolename = _o_.operrolename;
/*  912 */       this.mastername = _o_.mastername;
/*  913 */       this.itemid = _o_.itemid;
/*  914 */       this.historytype = _o_.historytype;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  919 */       this.timeline = _o_.timeline;
/*  920 */       this.beforecakeid = _o_.beforecakeid;
/*  921 */       this.aftercakeid = _o_.aftercakeid;
/*  922 */       this.operrolename = _o_.operrolename;
/*  923 */       this.mastername = _o_.mastername;
/*  924 */       this.itemid = _o_.itemid;
/*  925 */       this.historytype = _o_.historytype;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  931 */       _os_.marshal(this.timeline);
/*  932 */       _os_.marshal(this.beforecakeid);
/*  933 */       _os_.marshal(this.aftercakeid);
/*  934 */       _os_.marshal(this.operrolename, "UTF-16LE");
/*  935 */       _os_.marshal(this.mastername, "UTF-16LE");
/*  936 */       _os_.marshal(this.itemid);
/*  937 */       _os_.marshal(this.historytype);
/*  938 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  944 */       this.timeline = _os_.unmarshal_long();
/*  945 */       this.beforecakeid = _os_.unmarshal_int();
/*  946 */       this.aftercakeid = _os_.unmarshal_int();
/*  947 */       this.operrolename = _os_.unmarshal_String("UTF-16LE");
/*  948 */       this.mastername = _os_.unmarshal_String("UTF-16LE");
/*  949 */       this.itemid = _os_.unmarshal_int();
/*  950 */       this.historytype = _os_.unmarshal_int();
/*  951 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  957 */       int _size_ = 0;
/*  958 */       _size_ += CodedOutputStream.computeInt64Size(1, this.timeline);
/*  959 */       _size_ += CodedOutputStream.computeInt32Size(2, this.beforecakeid);
/*  960 */       _size_ += CodedOutputStream.computeInt32Size(3, this.aftercakeid);
/*      */       try
/*      */       {
/*  963 */         _size_ += CodedOutputStream.computeBytesSize(4, ByteString.copyFrom(this.operrolename, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/*  967 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */       try
/*      */       {
/*  971 */         _size_ += CodedOutputStream.computeBytesSize(5, ByteString.copyFrom(this.mastername, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/*  975 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*  977 */       _size_ += CodedOutputStream.computeInt32Size(6, this.itemid);
/*  978 */       _size_ += CodedOutputStream.computeInt32Size(7, this.historytype);
/*  979 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  987 */         _output_.writeInt64(1, this.timeline);
/*  988 */         _output_.writeInt32(2, this.beforecakeid);
/*  989 */         _output_.writeInt32(3, this.aftercakeid);
/*  990 */         _output_.writeBytes(4, ByteString.copyFrom(this.operrolename, "UTF-16LE"));
/*  991 */         _output_.writeBytes(5, ByteString.copyFrom(this.mastername, "UTF-16LE"));
/*  992 */         _output_.writeInt32(6, this.itemid);
/*  993 */         _output_.writeInt32(7, this.historytype);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  997 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  999 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1007 */         boolean done = false;
/* 1008 */         while (!done)
/*      */         {
/* 1010 */           int tag = _input_.readTag();
/* 1011 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1015 */             done = true;
/* 1016 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1020 */             this.timeline = _input_.readInt64();
/* 1021 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1025 */             this.beforecakeid = _input_.readInt32();
/* 1026 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1030 */             this.aftercakeid = _input_.readInt32();
/* 1031 */             break;
/*      */           
/*      */ 
/*      */           case 34: 
/* 1035 */             this.operrolename = _input_.readBytes().toString("UTF-16LE");
/* 1036 */             break;
/*      */           
/*      */ 
/*      */           case 42: 
/* 1040 */             this.mastername = _input_.readBytes().toString("UTF-16LE");
/* 1041 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1045 */             this.itemid = _input_.readInt32();
/* 1046 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1050 */             this.historytype = _input_.readInt32();
/* 1051 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1055 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1057 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1066 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1070 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1072 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CakeHistoryData copy()
/*      */     {
/* 1078 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CakeHistoryData toData()
/*      */     {
/* 1084 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.CakeHistoryData toBean()
/*      */     {
/* 1089 */       return new CakeHistoryData(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CakeHistoryData toDataIf()
/*      */     {
/* 1095 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.CakeHistoryData toBeanIf()
/*      */     {
/* 1100 */       return new CakeHistoryData(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1106 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1110 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1114 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1118 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1122 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1126 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1130 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTimeline()
/*      */     {
/* 1137 */       return this.timeline;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBeforecakeid()
/*      */     {
/* 1144 */       return this.beforecakeid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAftercakeid()
/*      */     {
/* 1151 */       return this.aftercakeid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getOperrolename()
/*      */     {
/* 1158 */       return this.operrolename;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getOperrolenameOctets()
/*      */     {
/* 1165 */       return Octets.wrap(getOperrolename(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getMastername()
/*      */     {
/* 1172 */       return this.mastername;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getMasternameOctets()
/*      */     {
/* 1179 */       return Octets.wrap(getMastername(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItemid()
/*      */     {
/* 1186 */       return this.itemid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHistorytype()
/*      */     {
/* 1193 */       return this.historytype;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTimeline(long _v_)
/*      */     {
/* 1200 */       this.timeline = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBeforecakeid(int _v_)
/*      */     {
/* 1207 */       this.beforecakeid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAftercakeid(int _v_)
/*      */     {
/* 1214 */       this.aftercakeid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOperrolename(String _v_)
/*      */     {
/* 1221 */       if (null == _v_)
/* 1222 */         throw new NullPointerException();
/* 1223 */       this.operrolename = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOperrolenameOctets(Octets _v_)
/*      */     {
/* 1230 */       setOperrolename(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMastername(String _v_)
/*      */     {
/* 1237 */       if (null == _v_)
/* 1238 */         throw new NullPointerException();
/* 1239 */       this.mastername = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMasternameOctets(Octets _v_)
/*      */     {
/* 1246 */       setMastername(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItemid(int _v_)
/*      */     {
/* 1253 */       this.itemid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHistorytype(int _v_)
/*      */     {
/* 1260 */       this.historytype = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1266 */       if (!(_o1_ instanceof Data)) return false;
/* 1267 */       Data _o_ = (Data)_o1_;
/* 1268 */       if (this.timeline != _o_.timeline) return false;
/* 1269 */       if (this.beforecakeid != _o_.beforecakeid) return false;
/* 1270 */       if (this.aftercakeid != _o_.aftercakeid) return false;
/* 1271 */       if (!this.operrolename.equals(_o_.operrolename)) return false;
/* 1272 */       if (!this.mastername.equals(_o_.mastername)) return false;
/* 1273 */       if (this.itemid != _o_.itemid) return false;
/* 1274 */       if (this.historytype != _o_.historytype) return false;
/* 1275 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1281 */       int _h_ = 0;
/* 1282 */       _h_ = (int)(_h_ + this.timeline);
/* 1283 */       _h_ += this.beforecakeid;
/* 1284 */       _h_ += this.aftercakeid;
/* 1285 */       _h_ += this.operrolename.hashCode();
/* 1286 */       _h_ += this.mastername.hashCode();
/* 1287 */       _h_ += this.itemid;
/* 1288 */       _h_ += this.historytype;
/* 1289 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1295 */       StringBuilder _sb_ = new StringBuilder();
/* 1296 */       _sb_.append("(");
/* 1297 */       _sb_.append(this.timeline);
/* 1298 */       _sb_.append(",");
/* 1299 */       _sb_.append(this.beforecakeid);
/* 1300 */       _sb_.append(",");
/* 1301 */       _sb_.append(this.aftercakeid);
/* 1302 */       _sb_.append(",");
/* 1303 */       _sb_.append("'").append(this.operrolename).append("'");
/* 1304 */       _sb_.append(",");
/* 1305 */       _sb_.append("'").append(this.mastername).append("'");
/* 1306 */       _sb_.append(",");
/* 1307 */       _sb_.append(this.itemid);
/* 1308 */       _sb_.append(",");
/* 1309 */       _sb_.append(this.historytype);
/* 1310 */       _sb_.append(")");
/* 1311 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CakeHistoryData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */