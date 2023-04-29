/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.util.HashMap;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ 
/*      */ public final class MailInfo extends XBean implements xbean.MailInfo
/*      */ {
/*      */   private xbean.MailContent mailcontent;
/*      */   private long createtime;
/*      */   private int state;
/*      */   private LinkedList<xbean.ThingBean> notitemlist;
/*      */   private LinkedList<xbean.Item> itemlist;
/*      */   private HashMap<Integer, Integer> extradatamap;
/*      */   private String tagid;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.mailcontent._reset_unsafe_();
/*   31 */     this.createtime = 0L;
/*   32 */     this.state = 0;
/*   33 */     this.notitemlist.clear();
/*   34 */     this.itemlist.clear();
/*   35 */     this.extradatamap.clear();
/*   36 */     this.tagid = "";
/*      */   }
/*      */   
/*      */   MailInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.mailcontent = new MailContent(0, this, "mailcontent");
/*   43 */     this.notitemlist = new LinkedList();
/*   44 */     this.itemlist = new LinkedList();
/*   45 */     this.extradatamap = new HashMap();
/*   46 */     this.tagid = "";
/*      */   }
/*      */   
/*      */   public MailInfo()
/*      */   {
/*   51 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public MailInfo(MailInfo _o_)
/*      */   {
/*   56 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   MailInfo(xbean.MailInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   61 */     super(_xp_, _vn_);
/*   62 */     if ((_o1_ instanceof MailInfo)) { assign((MailInfo)_o1_);
/*   63 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   64 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   65 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(MailInfo _o_) {
/*   70 */     _o_._xdb_verify_unsafe_();
/*   71 */     this.mailcontent = new MailContent(_o_.mailcontent, this, "mailcontent");
/*   72 */     this.createtime = _o_.createtime;
/*   73 */     this.state = _o_.state;
/*   74 */     this.notitemlist = new LinkedList();
/*   75 */     for (xbean.ThingBean _v_ : _o_.notitemlist)
/*   76 */       this.notitemlist.add(new ThingBean(_v_, this, "notitemlist"));
/*   77 */     this.itemlist = new LinkedList();
/*   78 */     for (xbean.Item _v_ : _o_.itemlist)
/*   79 */       this.itemlist.add(new Item(_v_, this, "itemlist"));
/*   80 */     this.extradatamap = new HashMap();
/*   81 */     for (Map.Entry<Integer, Integer> _e_ : _o_.extradatamap.entrySet())
/*   82 */       this.extradatamap.put(_e_.getKey(), _e_.getValue());
/*   83 */     this.tagid = _o_.tagid;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   88 */     this.mailcontent = new MailContent(_o_.mailcontent, this, "mailcontent");
/*   89 */     this.createtime = _o_.createtime;
/*   90 */     this.state = _o_.state;
/*   91 */     this.notitemlist = new LinkedList();
/*   92 */     for (xbean.ThingBean _v_ : _o_.notitemlist)
/*   93 */       this.notitemlist.add(new ThingBean(_v_, this, "notitemlist"));
/*   94 */     this.itemlist = new LinkedList();
/*   95 */     for (xbean.Item _v_ : _o_.itemlist)
/*   96 */       this.itemlist.add(new Item(_v_, this, "itemlist"));
/*   97 */     this.extradatamap = new HashMap();
/*   98 */     for (Map.Entry<Integer, Integer> _e_ : _o_.extradatamap.entrySet())
/*   99 */       this.extradatamap.put(_e_.getKey(), _e_.getValue());
/*  100 */     this.tagid = _o_.tagid;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  106 */     _xdb_verify_unsafe_();
/*  107 */     this.mailcontent.marshal(_os_);
/*  108 */     _os_.marshal(this.createtime);
/*  109 */     _os_.marshal(this.state);
/*  110 */     _os_.compact_uint32(this.notitemlist.size());
/*  111 */     for (xbean.ThingBean _v_ : this.notitemlist)
/*      */     {
/*  113 */       _v_.marshal(_os_);
/*      */     }
/*  115 */     _os_.compact_uint32(this.itemlist.size());
/*  116 */     for (xbean.Item _v_ : this.itemlist)
/*      */     {
/*  118 */       _v_.marshal(_os_);
/*      */     }
/*  120 */     _os_.compact_uint32(this.extradatamap.size());
/*  121 */     for (Map.Entry<Integer, Integer> _e_ : this.extradatamap.entrySet())
/*      */     {
/*  123 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  124 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  126 */     _os_.marshal(this.tagid, "UTF-16LE");
/*  127 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  133 */     _xdb_verify_unsafe_();
/*  134 */     this.mailcontent.unmarshal(_os_);
/*  135 */     this.createtime = _os_.unmarshal_long();
/*  136 */     this.state = _os_.unmarshal_int();
/*  137 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  139 */       xbean.ThingBean _v_ = new ThingBean(0, this, "notitemlist");
/*  140 */       _v_.unmarshal(_os_);
/*  141 */       this.notitemlist.add(_v_);
/*      */     }
/*  143 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  145 */       xbean.Item _v_ = new Item(0, this, "itemlist");
/*  146 */       _v_.unmarshal(_os_);
/*  147 */       this.itemlist.add(_v_);
/*      */     }
/*      */     
/*  150 */     int size = _os_.uncompact_uint32();
/*  151 */     if (size >= 12)
/*      */     {
/*  153 */       this.extradatamap = new HashMap(size * 2);
/*      */     }
/*  155 */     for (; size > 0; size--)
/*      */     {
/*  157 */       int _k_ = 0;
/*  158 */       _k_ = _os_.unmarshal_int();
/*  159 */       int _v_ = 0;
/*  160 */       _v_ = _os_.unmarshal_int();
/*  161 */       this.extradatamap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  164 */     this.tagid = _os_.unmarshal_String("UTF-16LE");
/*  165 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  171 */     _xdb_verify_unsafe_();
/*  172 */     int _size_ = 0;
/*  173 */     _size_ += CodedOutputStream.computeMessageSize(1, this.mailcontent);
/*  174 */     _size_ += CodedOutputStream.computeInt64Size(2, this.createtime);
/*  175 */     _size_ += CodedOutputStream.computeInt32Size(3, this.state);
/*  176 */     for (xbean.ThingBean _v_ : this.notitemlist)
/*      */     {
/*  178 */       _size_ += CodedOutputStream.computeMessageSize(4, _v_);
/*      */     }
/*  180 */     for (xbean.Item _v_ : this.itemlist)
/*      */     {
/*  182 */       _size_ += CodedOutputStream.computeMessageSize(5, _v_);
/*      */     }
/*  184 */     for (Map.Entry<Integer, Integer> _e_ : this.extradatamap.entrySet())
/*      */     {
/*  186 */       _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/*  187 */       _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*      */     try
/*      */     {
/*  191 */       _size_ += CodedOutputStream.computeBytesSize(7, ppbio.ByteString.copyFrom(this.tagid, "UTF-16LE"));
/*      */     }
/*      */     catch (java.io.UnsupportedEncodingException e)
/*      */     {
/*  195 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  197 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  203 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  206 */       _output_.writeMessage(1, this.mailcontent);
/*  207 */       _output_.writeInt64(2, this.createtime);
/*  208 */       _output_.writeInt32(3, this.state);
/*  209 */       for (xbean.ThingBean _v_ : this.notitemlist)
/*      */       {
/*  211 */         _output_.writeMessage(4, _v_);
/*      */       }
/*  213 */       for (xbean.Item _v_ : this.itemlist)
/*      */       {
/*  215 */         _output_.writeMessage(5, _v_);
/*      */       }
/*  217 */       for (Map.Entry<Integer, Integer> _e_ : this.extradatamap.entrySet())
/*      */       {
/*  219 */         _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/*  220 */         _output_.writeInt32(6, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  222 */       _output_.writeBytes(7, ppbio.ByteString.copyFrom(this.tagid, "UTF-16LE"));
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  226 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  228 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  234 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  237 */       boolean done = false;
/*  238 */       while (!done)
/*      */       {
/*  240 */         int tag = _input_.readTag();
/*  241 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  245 */           done = true;
/*  246 */           break;
/*      */         
/*      */ 
/*      */         case 10: 
/*  250 */           _input_.readMessage(this.mailcontent);
/*  251 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  255 */           this.createtime = _input_.readInt64();
/*  256 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  260 */           this.state = _input_.readInt32();
/*  261 */           break;
/*      */         
/*      */ 
/*      */         case 34: 
/*  265 */           xbean.ThingBean _v_ = new ThingBean(0, this, "notitemlist");
/*  266 */           _input_.readMessage(_v_);
/*  267 */           this.notitemlist.add(_v_);
/*  268 */           break;
/*      */         
/*      */ 
/*      */         case 42: 
/*  272 */           xbean.Item _v_ = new Item(0, this, "itemlist");
/*  273 */           _input_.readMessage(_v_);
/*  274 */           this.itemlist.add(_v_);
/*  275 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  279 */           int _k_ = 0;
/*  280 */           _k_ = _input_.readInt32();
/*  281 */           int readTag = _input_.readTag();
/*  282 */           if (48 != readTag)
/*      */           {
/*  284 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  286 */           int _v_ = 0;
/*  287 */           _v_ = _input_.readInt32();
/*  288 */           this.extradatamap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  289 */           break;
/*      */         
/*      */ 
/*      */         case 58: 
/*  293 */           this.tagid = _input_.readBytes().toString("UTF-16LE");
/*  294 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  298 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  300 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  309 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  313 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  315 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MailInfo copy()
/*      */   {
/*  321 */     _xdb_verify_unsafe_();
/*  322 */     return new MailInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MailInfo toData()
/*      */   {
/*  328 */     _xdb_verify_unsafe_();
/*  329 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MailInfo toBean()
/*      */   {
/*  334 */     _xdb_verify_unsafe_();
/*  335 */     return new MailInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MailInfo toDataIf()
/*      */   {
/*  341 */     _xdb_verify_unsafe_();
/*  342 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MailInfo toBeanIf()
/*      */   {
/*  347 */     _xdb_verify_unsafe_();
/*  348 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  354 */     _xdb_verify_unsafe_();
/*  355 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.MailContent getMailcontent()
/*      */   {
/*  362 */     _xdb_verify_unsafe_();
/*  363 */     return this.mailcontent;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCreatetime()
/*      */   {
/*  370 */     _xdb_verify_unsafe_();
/*  371 */     return this.createtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getState()
/*      */   {
/*  378 */     _xdb_verify_unsafe_();
/*  379 */     return this.state;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.ThingBean> getNotitemlist()
/*      */   {
/*  386 */     _xdb_verify_unsafe_();
/*  387 */     return xdb.Logs.logList(new LogKey(this, "notitemlist"), this.notitemlist);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.ThingBean> getNotitemlistAsData()
/*      */   {
/*  393 */     _xdb_verify_unsafe_();
/*      */     
/*  395 */     MailInfo _o_ = this;
/*  396 */     List<xbean.ThingBean> notitemlist = new LinkedList();
/*  397 */     for (xbean.ThingBean _v_ : _o_.notitemlist)
/*  398 */       notitemlist.add(new ThingBean.Data(_v_));
/*  399 */     return notitemlist;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.Item> getItemlist()
/*      */   {
/*  406 */     _xdb_verify_unsafe_();
/*  407 */     return xdb.Logs.logList(new LogKey(this, "itemlist"), this.itemlist);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.Item> getItemlistAsData()
/*      */   {
/*  413 */     _xdb_verify_unsafe_();
/*      */     
/*  415 */     MailInfo _o_ = this;
/*  416 */     List<xbean.Item> itemlist = new LinkedList();
/*  417 */     for (xbean.Item _v_ : _o_.itemlist)
/*  418 */       itemlist.add(new Item.Data(_v_));
/*  419 */     return itemlist;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getExtradatamap()
/*      */   {
/*  426 */     _xdb_verify_unsafe_();
/*  427 */     return xdb.Logs.logMap(new LogKey(this, "extradatamap"), this.extradatamap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getExtradatamapAsData()
/*      */   {
/*  434 */     _xdb_verify_unsafe_();
/*      */     
/*  436 */     MailInfo _o_ = this;
/*  437 */     Map<Integer, Integer> extradatamap = new HashMap();
/*  438 */     for (Map.Entry<Integer, Integer> _e_ : _o_.extradatamap.entrySet())
/*  439 */       extradatamap.put(_e_.getKey(), _e_.getValue());
/*  440 */     return extradatamap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getTagid()
/*      */   {
/*  447 */     _xdb_verify_unsafe_();
/*  448 */     return this.tagid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getTagidOctets()
/*      */   {
/*  455 */     _xdb_verify_unsafe_();
/*  456 */     return Octets.wrap(getTagid(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCreatetime(long _v_)
/*      */   {
/*  463 */     _xdb_verify_unsafe_();
/*  464 */     xdb.Logs.logIf(new LogKey(this, "createtime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  468 */         new xdb.logs.LogLong(this, MailInfo.this.createtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  472 */             MailInfo.this.createtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  476 */     });
/*  477 */     this.createtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setState(int _v_)
/*      */   {
/*  484 */     _xdb_verify_unsafe_();
/*  485 */     xdb.Logs.logIf(new LogKey(this, "state")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  489 */         new xdb.logs.LogInt(this, MailInfo.this.state)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  493 */             MailInfo.this.state = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  497 */     });
/*  498 */     this.state = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTagid(String _v_)
/*      */   {
/*  505 */     _xdb_verify_unsafe_();
/*  506 */     if (null == _v_)
/*  507 */       throw new NullPointerException();
/*  508 */     xdb.Logs.logIf(new LogKey(this, "tagid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  512 */         new xdb.logs.LogString(this, MailInfo.this.tagid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  516 */             MailInfo.this.tagid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  520 */     });
/*  521 */     this.tagid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTagidOctets(Octets _v_)
/*      */   {
/*  528 */     _xdb_verify_unsafe_();
/*  529 */     setTagid(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  535 */     _xdb_verify_unsafe_();
/*  536 */     MailInfo _o_ = null;
/*  537 */     if ((_o1_ instanceof MailInfo)) { _o_ = (MailInfo)_o1_;
/*  538 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  539 */       return false;
/*  540 */     if (!this.mailcontent.equals(_o_.mailcontent)) return false;
/*  541 */     if (this.createtime != _o_.createtime) return false;
/*  542 */     if (this.state != _o_.state) return false;
/*  543 */     if (!this.notitemlist.equals(_o_.notitemlist)) return false;
/*  544 */     if (!this.itemlist.equals(_o_.itemlist)) return false;
/*  545 */     if (!this.extradatamap.equals(_o_.extradatamap)) return false;
/*  546 */     if (!this.tagid.equals(_o_.tagid)) return false;
/*  547 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  553 */     _xdb_verify_unsafe_();
/*  554 */     int _h_ = 0;
/*  555 */     _h_ += this.mailcontent.hashCode();
/*  556 */     _h_ = (int)(_h_ + this.createtime);
/*  557 */     _h_ += this.state;
/*  558 */     _h_ += this.notitemlist.hashCode();
/*  559 */     _h_ += this.itemlist.hashCode();
/*  560 */     _h_ += this.extradatamap.hashCode();
/*  561 */     _h_ += this.tagid.hashCode();
/*  562 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  568 */     _xdb_verify_unsafe_();
/*  569 */     StringBuilder _sb_ = new StringBuilder();
/*  570 */     _sb_.append("(");
/*  571 */     _sb_.append(this.mailcontent);
/*  572 */     _sb_.append(",");
/*  573 */     _sb_.append(this.createtime);
/*  574 */     _sb_.append(",");
/*  575 */     _sb_.append(this.state);
/*  576 */     _sb_.append(",");
/*  577 */     _sb_.append(this.notitemlist);
/*  578 */     _sb_.append(",");
/*  579 */     _sb_.append(this.itemlist);
/*  580 */     _sb_.append(",");
/*  581 */     _sb_.append(this.extradatamap);
/*  582 */     _sb_.append(",");
/*  583 */     _sb_.append("'").append(this.tagid).append("'");
/*  584 */     _sb_.append(")");
/*  585 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  591 */     ListenableBean lb = new ListenableBean();
/*  592 */     lb.add(new ListenableChanged().setVarName("mailcontent"));
/*  593 */     lb.add(new ListenableChanged().setVarName("createtime"));
/*  594 */     lb.add(new ListenableChanged().setVarName("state"));
/*  595 */     lb.add(new ListenableChanged().setVarName("notitemlist"));
/*  596 */     lb.add(new ListenableChanged().setVarName("itemlist"));
/*  597 */     lb.add(new xdb.logs.ListenableMap().setVarName("extradatamap"));
/*  598 */     lb.add(new ListenableChanged().setVarName("tagid"));
/*  599 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.MailInfo {
/*      */     private Const() {}
/*      */     
/*      */     MailInfo nThis() {
/*  606 */       return MailInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  612 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MailInfo copy()
/*      */     {
/*  618 */       return MailInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MailInfo toData()
/*      */     {
/*  624 */       return MailInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.MailInfo toBean()
/*      */     {
/*  629 */       return MailInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MailInfo toDataIf()
/*      */     {
/*  635 */       return MailInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.MailInfo toBeanIf()
/*      */     {
/*  640 */       return MailInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.MailContent getMailcontent()
/*      */     {
/*  647 */       MailInfo.this._xdb_verify_unsafe_();
/*  648 */       return (xbean.MailContent)xdb.Consts.toConst(MailInfo.this.mailcontent);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCreatetime()
/*      */     {
/*  655 */       MailInfo.this._xdb_verify_unsafe_();
/*  656 */       return MailInfo.this.createtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getState()
/*      */     {
/*  663 */       MailInfo.this._xdb_verify_unsafe_();
/*  664 */       return MailInfo.this.state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.ThingBean> getNotitemlist()
/*      */     {
/*  671 */       MailInfo.this._xdb_verify_unsafe_();
/*  672 */       return xdb.Consts.constList(MailInfo.this.notitemlist);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.ThingBean> getNotitemlistAsData()
/*      */     {
/*  678 */       MailInfo.this._xdb_verify_unsafe_();
/*      */       
/*  680 */       MailInfo _o_ = MailInfo.this;
/*  681 */       List<xbean.ThingBean> notitemlist = new LinkedList();
/*  682 */       for (xbean.ThingBean _v_ : _o_.notitemlist)
/*  683 */         notitemlist.add(new ThingBean.Data(_v_));
/*  684 */       return notitemlist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.Item> getItemlist()
/*      */     {
/*  691 */       MailInfo.this._xdb_verify_unsafe_();
/*  692 */       return xdb.Consts.constList(MailInfo.this.itemlist);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.Item> getItemlistAsData()
/*      */     {
/*  698 */       MailInfo.this._xdb_verify_unsafe_();
/*      */       
/*  700 */       MailInfo _o_ = MailInfo.this;
/*  701 */       List<xbean.Item> itemlist = new LinkedList();
/*  702 */       for (xbean.Item _v_ : _o_.itemlist)
/*  703 */         itemlist.add(new Item.Data(_v_));
/*  704 */       return itemlist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getExtradatamap()
/*      */     {
/*  711 */       MailInfo.this._xdb_verify_unsafe_();
/*  712 */       return xdb.Consts.constMap(MailInfo.this.extradatamap);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getExtradatamapAsData()
/*      */     {
/*  719 */       MailInfo.this._xdb_verify_unsafe_();
/*      */       
/*  721 */       MailInfo _o_ = MailInfo.this;
/*  722 */       Map<Integer, Integer> extradatamap = new HashMap();
/*  723 */       for (Map.Entry<Integer, Integer> _e_ : _o_.extradatamap.entrySet())
/*  724 */         extradatamap.put(_e_.getKey(), _e_.getValue());
/*  725 */       return extradatamap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getTagid()
/*      */     {
/*  732 */       MailInfo.this._xdb_verify_unsafe_();
/*  733 */       return MailInfo.this.tagid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getTagidOctets()
/*      */     {
/*  740 */       MailInfo.this._xdb_verify_unsafe_();
/*  741 */       return MailInfo.this.getTagidOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCreatetime(long _v_)
/*      */     {
/*  748 */       MailInfo.this._xdb_verify_unsafe_();
/*  749 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setState(int _v_)
/*      */     {
/*  756 */       MailInfo.this._xdb_verify_unsafe_();
/*  757 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTagid(String _v_)
/*      */     {
/*  764 */       MailInfo.this._xdb_verify_unsafe_();
/*  765 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTagidOctets(Octets _v_)
/*      */     {
/*  772 */       MailInfo.this._xdb_verify_unsafe_();
/*  773 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  779 */       MailInfo.this._xdb_verify_unsafe_();
/*  780 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  786 */       MailInfo.this._xdb_verify_unsafe_();
/*  787 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  793 */       return MailInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  799 */       return MailInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  805 */       MailInfo.this._xdb_verify_unsafe_();
/*  806 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  812 */       return MailInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  818 */       return MailInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  824 */       MailInfo.this._xdb_verify_unsafe_();
/*  825 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  831 */       return MailInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  837 */       return MailInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  843 */       return MailInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  849 */       return MailInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  855 */       return MailInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  861 */       return MailInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  867 */       return MailInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.MailInfo
/*      */   {
/*      */     private xbean.MailContent mailcontent;
/*      */     
/*      */     private long createtime;
/*      */     
/*      */     private int state;
/*      */     
/*      */     private LinkedList<xbean.ThingBean> notitemlist;
/*      */     
/*      */     private LinkedList<xbean.Item> itemlist;
/*      */     
/*      */     private HashMap<Integer, Integer> extradatamap;
/*      */     
/*      */     private String tagid;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  891 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  896 */       this.mailcontent = new MailContent.Data();
/*  897 */       this.notitemlist = new LinkedList();
/*  898 */       this.itemlist = new LinkedList();
/*  899 */       this.extradatamap = new HashMap();
/*  900 */       this.tagid = "";
/*      */     }
/*      */     
/*      */     Data(xbean.MailInfo _o1_)
/*      */     {
/*  905 */       if ((_o1_ instanceof MailInfo)) { assign((MailInfo)_o1_);
/*  906 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  907 */       } else if ((_o1_ instanceof MailInfo.Const)) assign(((MailInfo.Const)_o1_).nThis()); else {
/*  908 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(MailInfo _o_) {
/*  913 */       this.mailcontent = new MailContent.Data(_o_.mailcontent);
/*  914 */       this.createtime = _o_.createtime;
/*  915 */       this.state = _o_.state;
/*  916 */       this.notitemlist = new LinkedList();
/*  917 */       for (xbean.ThingBean _v_ : _o_.notitemlist)
/*  918 */         this.notitemlist.add(new ThingBean.Data(_v_));
/*  919 */       this.itemlist = new LinkedList();
/*  920 */       for (xbean.Item _v_ : _o_.itemlist)
/*  921 */         this.itemlist.add(new Item.Data(_v_));
/*  922 */       this.extradatamap = new HashMap();
/*  923 */       for (Map.Entry<Integer, Integer> _e_ : _o_.extradatamap.entrySet())
/*  924 */         this.extradatamap.put(_e_.getKey(), _e_.getValue());
/*  925 */       this.tagid = _o_.tagid;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  930 */       this.mailcontent = new MailContent.Data(_o_.mailcontent);
/*  931 */       this.createtime = _o_.createtime;
/*  932 */       this.state = _o_.state;
/*  933 */       this.notitemlist = new LinkedList();
/*  934 */       for (xbean.ThingBean _v_ : _o_.notitemlist)
/*  935 */         this.notitemlist.add(new ThingBean.Data(_v_));
/*  936 */       this.itemlist = new LinkedList();
/*  937 */       for (xbean.Item _v_ : _o_.itemlist)
/*  938 */         this.itemlist.add(new Item.Data(_v_));
/*  939 */       this.extradatamap = new HashMap();
/*  940 */       for (Map.Entry<Integer, Integer> _e_ : _o_.extradatamap.entrySet())
/*  941 */         this.extradatamap.put(_e_.getKey(), _e_.getValue());
/*  942 */       this.tagid = _o_.tagid;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  948 */       this.mailcontent.marshal(_os_);
/*  949 */       _os_.marshal(this.createtime);
/*  950 */       _os_.marshal(this.state);
/*  951 */       _os_.compact_uint32(this.notitemlist.size());
/*  952 */       for (xbean.ThingBean _v_ : this.notitemlist)
/*      */       {
/*  954 */         _v_.marshal(_os_);
/*      */       }
/*  956 */       _os_.compact_uint32(this.itemlist.size());
/*  957 */       for (xbean.Item _v_ : this.itemlist)
/*      */       {
/*  959 */         _v_.marshal(_os_);
/*      */       }
/*  961 */       _os_.compact_uint32(this.extradatamap.size());
/*  962 */       for (Map.Entry<Integer, Integer> _e_ : this.extradatamap.entrySet())
/*      */       {
/*  964 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  965 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  967 */       _os_.marshal(this.tagid, "UTF-16LE");
/*  968 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  974 */       this.mailcontent.unmarshal(_os_);
/*  975 */       this.createtime = _os_.unmarshal_long();
/*  976 */       this.state = _os_.unmarshal_int();
/*  977 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  979 */         xbean.ThingBean _v_ = xbean.Pod.newThingBeanData();
/*  980 */         _v_.unmarshal(_os_);
/*  981 */         this.notitemlist.add(_v_);
/*      */       }
/*  983 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  985 */         xbean.Item _v_ = xbean.Pod.newItemData();
/*  986 */         _v_.unmarshal(_os_);
/*  987 */         this.itemlist.add(_v_);
/*      */       }
/*      */       
/*  990 */       int size = _os_.uncompact_uint32();
/*  991 */       if (size >= 12)
/*      */       {
/*  993 */         this.extradatamap = new HashMap(size * 2);
/*      */       }
/*  995 */       for (; size > 0; size--)
/*      */       {
/*  997 */         int _k_ = 0;
/*  998 */         _k_ = _os_.unmarshal_int();
/*  999 */         int _v_ = 0;
/* 1000 */         _v_ = _os_.unmarshal_int();
/* 1001 */         this.extradatamap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 1004 */       this.tagid = _os_.unmarshal_String("UTF-16LE");
/* 1005 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1011 */       int _size_ = 0;
/* 1012 */       _size_ += CodedOutputStream.computeMessageSize(1, this.mailcontent);
/* 1013 */       _size_ += CodedOutputStream.computeInt64Size(2, this.createtime);
/* 1014 */       _size_ += CodedOutputStream.computeInt32Size(3, this.state);
/* 1015 */       for (xbean.ThingBean _v_ : this.notitemlist)
/*      */       {
/* 1017 */         _size_ += CodedOutputStream.computeMessageSize(4, _v_);
/*      */       }
/* 1019 */       for (xbean.Item _v_ : this.itemlist)
/*      */       {
/* 1021 */         _size_ += CodedOutputStream.computeMessageSize(5, _v_);
/*      */       }
/* 1023 */       for (Map.Entry<Integer, Integer> _e_ : this.extradatamap.entrySet())
/*      */       {
/* 1025 */         _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/* 1026 */         _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*      */       try
/*      */       {
/* 1030 */         _size_ += CodedOutputStream.computeBytesSize(7, ppbio.ByteString.copyFrom(this.tagid, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/* 1034 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 1036 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1044 */         _output_.writeMessage(1, this.mailcontent);
/* 1045 */         _output_.writeInt64(2, this.createtime);
/* 1046 */         _output_.writeInt32(3, this.state);
/* 1047 */         for (xbean.ThingBean _v_ : this.notitemlist)
/*      */         {
/* 1049 */           _output_.writeMessage(4, _v_);
/*      */         }
/* 1051 */         for (xbean.Item _v_ : this.itemlist)
/*      */         {
/* 1053 */           _output_.writeMessage(5, _v_);
/*      */         }
/* 1055 */         for (Map.Entry<Integer, Integer> _e_ : this.extradatamap.entrySet())
/*      */         {
/* 1057 */           _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/* 1058 */           _output_.writeInt32(6, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 1060 */         _output_.writeBytes(7, ppbio.ByteString.copyFrom(this.tagid, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1064 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1066 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1074 */         boolean done = false;
/* 1075 */         while (!done)
/*      */         {
/* 1077 */           int tag = _input_.readTag();
/* 1078 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1082 */             done = true;
/* 1083 */             break;
/*      */           
/*      */ 
/*      */           case 10: 
/* 1087 */             _input_.readMessage(this.mailcontent);
/* 1088 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1092 */             this.createtime = _input_.readInt64();
/* 1093 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1097 */             this.state = _input_.readInt32();
/* 1098 */             break;
/*      */           
/*      */ 
/*      */           case 34: 
/* 1102 */             xbean.ThingBean _v_ = xbean.Pod.newThingBeanData();
/* 1103 */             _input_.readMessage(_v_);
/* 1104 */             this.notitemlist.add(_v_);
/* 1105 */             break;
/*      */           
/*      */ 
/*      */           case 42: 
/* 1109 */             xbean.Item _v_ = xbean.Pod.newItemData();
/* 1110 */             _input_.readMessage(_v_);
/* 1111 */             this.itemlist.add(_v_);
/* 1112 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1116 */             int _k_ = 0;
/* 1117 */             _k_ = _input_.readInt32();
/* 1118 */             int readTag = _input_.readTag();
/* 1119 */             if (48 != readTag)
/*      */             {
/* 1121 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1123 */             int _v_ = 0;
/* 1124 */             _v_ = _input_.readInt32();
/* 1125 */             this.extradatamap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1126 */             break;
/*      */           
/*      */ 
/*      */           case 58: 
/* 1130 */             this.tagid = _input_.readBytes().toString("UTF-16LE");
/* 1131 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1135 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1137 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1146 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1150 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1152 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MailInfo copy()
/*      */     {
/* 1158 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MailInfo toData()
/*      */     {
/* 1164 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.MailInfo toBean()
/*      */     {
/* 1169 */       return new MailInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MailInfo toDataIf()
/*      */     {
/* 1175 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.MailInfo toBeanIf()
/*      */     {
/* 1180 */       return new MailInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1186 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1190 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1194 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1198 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1202 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1206 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1210 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.MailContent getMailcontent()
/*      */     {
/* 1217 */       return this.mailcontent;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCreatetime()
/*      */     {
/* 1224 */       return this.createtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getState()
/*      */     {
/* 1231 */       return this.state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.ThingBean> getNotitemlist()
/*      */     {
/* 1238 */       return this.notitemlist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.ThingBean> getNotitemlistAsData()
/*      */     {
/* 1245 */       return this.notitemlist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.Item> getItemlist()
/*      */     {
/* 1252 */       return this.itemlist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.Item> getItemlistAsData()
/*      */     {
/* 1259 */       return this.itemlist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getExtradatamap()
/*      */     {
/* 1266 */       return this.extradatamap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getExtradatamapAsData()
/*      */     {
/* 1273 */       return this.extradatamap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getTagid()
/*      */     {
/* 1280 */       return this.tagid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getTagidOctets()
/*      */     {
/* 1287 */       return Octets.wrap(getTagid(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCreatetime(long _v_)
/*      */     {
/* 1294 */       this.createtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setState(int _v_)
/*      */     {
/* 1301 */       this.state = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTagid(String _v_)
/*      */     {
/* 1308 */       if (null == _v_)
/* 1309 */         throw new NullPointerException();
/* 1310 */       this.tagid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTagidOctets(Octets _v_)
/*      */     {
/* 1317 */       setTagid(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1323 */       if (!(_o1_ instanceof Data)) return false;
/* 1324 */       Data _o_ = (Data)_o1_;
/* 1325 */       if (!this.mailcontent.equals(_o_.mailcontent)) return false;
/* 1326 */       if (this.createtime != _o_.createtime) return false;
/* 1327 */       if (this.state != _o_.state) return false;
/* 1328 */       if (!this.notitemlist.equals(_o_.notitemlist)) return false;
/* 1329 */       if (!this.itemlist.equals(_o_.itemlist)) return false;
/* 1330 */       if (!this.extradatamap.equals(_o_.extradatamap)) return false;
/* 1331 */       if (!this.tagid.equals(_o_.tagid)) return false;
/* 1332 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1338 */       int _h_ = 0;
/* 1339 */       _h_ += this.mailcontent.hashCode();
/* 1340 */       _h_ = (int)(_h_ + this.createtime);
/* 1341 */       _h_ += this.state;
/* 1342 */       _h_ += this.notitemlist.hashCode();
/* 1343 */       _h_ += this.itemlist.hashCode();
/* 1344 */       _h_ += this.extradatamap.hashCode();
/* 1345 */       _h_ += this.tagid.hashCode();
/* 1346 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1352 */       StringBuilder _sb_ = new StringBuilder();
/* 1353 */       _sb_.append("(");
/* 1354 */       _sb_.append(this.mailcontent);
/* 1355 */       _sb_.append(",");
/* 1356 */       _sb_.append(this.createtime);
/* 1357 */       _sb_.append(",");
/* 1358 */       _sb_.append(this.state);
/* 1359 */       _sb_.append(",");
/* 1360 */       _sb_.append(this.notitemlist);
/* 1361 */       _sb_.append(",");
/* 1362 */       _sb_.append(this.itemlist);
/* 1363 */       _sb_.append(",");
/* 1364 */       _sb_.append(this.extradatamap);
/* 1365 */       _sb_.append(",");
/* 1366 */       _sb_.append("'").append(this.tagid).append("'");
/* 1367 */       _sb_.append(")");
/* 1368 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MailInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */