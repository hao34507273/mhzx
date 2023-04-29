/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import ppbio.ByteString;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.Listenable;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ import xdb.logs.LogObject;
/*      */ import xdb.logs.LogString;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class IdipNoticeInfo
/*      */   extends XBean
/*      */   implements xbean.IdipNoticeInfo
/*      */ {
/*      */   private int noticetype;
/*      */   private int displaytype;
/*      */   private int hreftype;
/*      */   private String hreftext;
/*      */   private String hrefurl;
/*      */   private int sendtype;
/*      */   private String noticetitle;
/*      */   private String noticecontent;
/*      */   private String pictureurl;
/*      */   private long starttime;
/*      */   private long endtime;
/*      */   private int minopenserverdays;
/*      */   private int maxopenserverdays;
/*      */   private int mincreatroledays;
/*      */   private int maxcreatroledays;
/*      */   private int minrolelevel;
/*      */   private int maxrolelevel;
/*      */   private long minsaveamt;
/*      */   private long maxsaveamt;
/*      */   private int noticetag;
/*      */   private boolean badge;
/*      */   private int noticesortid;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   60 */     this.noticetype = 0;
/*   61 */     this.displaytype = 0;
/*   62 */     this.hreftype = 0;
/*   63 */     this.hreftext = "";
/*   64 */     this.hrefurl = "";
/*   65 */     this.sendtype = 0;
/*   66 */     this.noticetitle = "";
/*   67 */     this.noticecontent = "";
/*   68 */     this.pictureurl = "";
/*   69 */     this.starttime = 0L;
/*   70 */     this.endtime = 0L;
/*   71 */     this.minopenserverdays = 0;
/*   72 */     this.maxopenserverdays = 0;
/*   73 */     this.mincreatroledays = 0;
/*   74 */     this.maxcreatroledays = 0;
/*   75 */     this.minrolelevel = 0;
/*   76 */     this.maxrolelevel = 0;
/*   77 */     this.minsaveamt = 0L;
/*   78 */     this.maxsaveamt = 0L;
/*   79 */     this.noticetag = 0;
/*   80 */     this.badge = false;
/*   81 */     this.noticesortid = 0;
/*      */   }
/*      */   
/*      */   IdipNoticeInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   86 */     super(_xp_, _vn_);
/*   87 */     this.hreftext = "";
/*   88 */     this.hrefurl = "";
/*   89 */     this.noticetitle = "";
/*   90 */     this.noticecontent = "";
/*   91 */     this.pictureurl = "";
/*      */   }
/*      */   
/*      */   public IdipNoticeInfo()
/*      */   {
/*   96 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public IdipNoticeInfo(IdipNoticeInfo _o_)
/*      */   {
/*  101 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   IdipNoticeInfo(xbean.IdipNoticeInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*  106 */     super(_xp_, _vn_);
/*  107 */     if ((_o1_ instanceof IdipNoticeInfo)) { assign((IdipNoticeInfo)_o1_);
/*  108 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  109 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  110 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(IdipNoticeInfo _o_) {
/*  115 */     _o_._xdb_verify_unsafe_();
/*  116 */     this.noticetype = _o_.noticetype;
/*  117 */     this.displaytype = _o_.displaytype;
/*  118 */     this.hreftype = _o_.hreftype;
/*  119 */     this.hreftext = _o_.hreftext;
/*  120 */     this.hrefurl = _o_.hrefurl;
/*  121 */     this.sendtype = _o_.sendtype;
/*  122 */     this.noticetitle = _o_.noticetitle;
/*  123 */     this.noticecontent = _o_.noticecontent;
/*  124 */     this.pictureurl = _o_.pictureurl;
/*  125 */     this.starttime = _o_.starttime;
/*  126 */     this.endtime = _o_.endtime;
/*  127 */     this.minopenserverdays = _o_.minopenserverdays;
/*  128 */     this.maxopenserverdays = _o_.maxopenserverdays;
/*  129 */     this.mincreatroledays = _o_.mincreatroledays;
/*  130 */     this.maxcreatroledays = _o_.maxcreatroledays;
/*  131 */     this.minrolelevel = _o_.minrolelevel;
/*  132 */     this.maxrolelevel = _o_.maxrolelevel;
/*  133 */     this.minsaveamt = _o_.minsaveamt;
/*  134 */     this.maxsaveamt = _o_.maxsaveamt;
/*  135 */     this.noticetag = _o_.noticetag;
/*  136 */     this.badge = _o_.badge;
/*  137 */     this.noticesortid = _o_.noticesortid;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*  142 */     this.noticetype = _o_.noticetype;
/*  143 */     this.displaytype = _o_.displaytype;
/*  144 */     this.hreftype = _o_.hreftype;
/*  145 */     this.hreftext = _o_.hreftext;
/*  146 */     this.hrefurl = _o_.hrefurl;
/*  147 */     this.sendtype = _o_.sendtype;
/*  148 */     this.noticetitle = _o_.noticetitle;
/*  149 */     this.noticecontent = _o_.noticecontent;
/*  150 */     this.pictureurl = _o_.pictureurl;
/*  151 */     this.starttime = _o_.starttime;
/*  152 */     this.endtime = _o_.endtime;
/*  153 */     this.minopenserverdays = _o_.minopenserverdays;
/*  154 */     this.maxopenserverdays = _o_.maxopenserverdays;
/*  155 */     this.mincreatroledays = _o_.mincreatroledays;
/*  156 */     this.maxcreatroledays = _o_.maxcreatroledays;
/*  157 */     this.minrolelevel = _o_.minrolelevel;
/*  158 */     this.maxrolelevel = _o_.maxrolelevel;
/*  159 */     this.minsaveamt = _o_.minsaveamt;
/*  160 */     this.maxsaveamt = _o_.maxsaveamt;
/*  161 */     this.noticetag = _o_.noticetag;
/*  162 */     this.badge = _o_.badge;
/*  163 */     this.noticesortid = _o_.noticesortid;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  169 */     _xdb_verify_unsafe_();
/*  170 */     _os_.marshal(this.noticetype);
/*  171 */     _os_.marshal(this.displaytype);
/*  172 */     _os_.marshal(this.hreftype);
/*  173 */     _os_.marshal(this.hreftext, "UTF-16LE");
/*  174 */     _os_.marshal(this.hrefurl, "UTF-16LE");
/*  175 */     _os_.marshal(this.sendtype);
/*  176 */     _os_.marshal(this.noticetitle, "UTF-16LE");
/*  177 */     _os_.marshal(this.noticecontent, "UTF-16LE");
/*  178 */     _os_.marshal(this.pictureurl, "UTF-16LE");
/*  179 */     _os_.marshal(this.starttime);
/*  180 */     _os_.marshal(this.endtime);
/*  181 */     _os_.marshal(this.minopenserverdays);
/*  182 */     _os_.marshal(this.maxopenserverdays);
/*  183 */     _os_.marshal(this.mincreatroledays);
/*  184 */     _os_.marshal(this.maxcreatroledays);
/*  185 */     _os_.marshal(this.minrolelevel);
/*  186 */     _os_.marshal(this.maxrolelevel);
/*  187 */     _os_.marshal(this.minsaveamt);
/*  188 */     _os_.marshal(this.maxsaveamt);
/*  189 */     _os_.marshal(this.noticetag);
/*  190 */     _os_.marshal(this.badge);
/*  191 */     _os_.marshal(this.noticesortid);
/*  192 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  198 */     _xdb_verify_unsafe_();
/*  199 */     this.noticetype = _os_.unmarshal_int();
/*  200 */     this.displaytype = _os_.unmarshal_int();
/*  201 */     this.hreftype = _os_.unmarshal_int();
/*  202 */     this.hreftext = _os_.unmarshal_String("UTF-16LE");
/*  203 */     this.hrefurl = _os_.unmarshal_String("UTF-16LE");
/*  204 */     this.sendtype = _os_.unmarshal_int();
/*  205 */     this.noticetitle = _os_.unmarshal_String("UTF-16LE");
/*  206 */     this.noticecontent = _os_.unmarshal_String("UTF-16LE");
/*  207 */     this.pictureurl = _os_.unmarshal_String("UTF-16LE");
/*  208 */     this.starttime = _os_.unmarshal_long();
/*  209 */     this.endtime = _os_.unmarshal_long();
/*  210 */     this.minopenserverdays = _os_.unmarshal_int();
/*  211 */     this.maxopenserverdays = _os_.unmarshal_int();
/*  212 */     this.mincreatroledays = _os_.unmarshal_int();
/*  213 */     this.maxcreatroledays = _os_.unmarshal_int();
/*  214 */     this.minrolelevel = _os_.unmarshal_int();
/*  215 */     this.maxrolelevel = _os_.unmarshal_int();
/*  216 */     this.minsaveamt = _os_.unmarshal_long();
/*  217 */     this.maxsaveamt = _os_.unmarshal_long();
/*  218 */     this.noticetag = _os_.unmarshal_int();
/*  219 */     this.badge = _os_.unmarshal_boolean();
/*  220 */     this.noticesortid = _os_.unmarshal_int();
/*  221 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  227 */     _xdb_verify_unsafe_();
/*  228 */     int _size_ = 0;
/*  229 */     _size_ += CodedOutputStream.computeInt32Size(1, this.noticetype);
/*  230 */     _size_ += CodedOutputStream.computeInt32Size(2, this.displaytype);
/*  231 */     _size_ += CodedOutputStream.computeInt32Size(3, this.hreftype);
/*      */     try
/*      */     {
/*  234 */       _size_ += CodedOutputStream.computeBytesSize(4, ByteString.copyFrom(this.hreftext, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  238 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*      */     try
/*      */     {
/*  242 */       _size_ += CodedOutputStream.computeBytesSize(5, ByteString.copyFrom(this.hrefurl, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  246 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  248 */     _size_ += CodedOutputStream.computeInt32Size(6, this.sendtype);
/*      */     try
/*      */     {
/*  251 */       _size_ += CodedOutputStream.computeBytesSize(7, ByteString.copyFrom(this.noticetitle, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  255 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*      */     try
/*      */     {
/*  259 */       _size_ += CodedOutputStream.computeBytesSize(8, ByteString.copyFrom(this.noticecontent, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  263 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*      */     try
/*      */     {
/*  267 */       _size_ += CodedOutputStream.computeBytesSize(9, ByteString.copyFrom(this.pictureurl, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  271 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  273 */     _size_ += CodedOutputStream.computeInt64Size(10, this.starttime);
/*  274 */     _size_ += CodedOutputStream.computeInt64Size(11, this.endtime);
/*  275 */     _size_ += CodedOutputStream.computeInt32Size(12, this.minopenserverdays);
/*  276 */     _size_ += CodedOutputStream.computeInt32Size(13, this.maxopenserverdays);
/*  277 */     _size_ += CodedOutputStream.computeInt32Size(14, this.mincreatroledays);
/*  278 */     _size_ += CodedOutputStream.computeInt32Size(15, this.maxcreatroledays);
/*  279 */     _size_ += CodedOutputStream.computeInt32Size(16, this.minrolelevel);
/*  280 */     _size_ += CodedOutputStream.computeInt32Size(17, this.maxrolelevel);
/*  281 */     _size_ += CodedOutputStream.computeInt64Size(18, this.minsaveamt);
/*  282 */     _size_ += CodedOutputStream.computeInt64Size(19, this.maxsaveamt);
/*  283 */     _size_ += CodedOutputStream.computeInt32Size(20, this.noticetag);
/*  284 */     _size_ += CodedOutputStream.computeBoolSize(21, this.badge);
/*  285 */     _size_ += CodedOutputStream.computeInt32Size(22, this.noticesortid);
/*  286 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  292 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  295 */       _output_.writeInt32(1, this.noticetype);
/*  296 */       _output_.writeInt32(2, this.displaytype);
/*  297 */       _output_.writeInt32(3, this.hreftype);
/*  298 */       _output_.writeBytes(4, ByteString.copyFrom(this.hreftext, "UTF-16LE"));
/*  299 */       _output_.writeBytes(5, ByteString.copyFrom(this.hrefurl, "UTF-16LE"));
/*  300 */       _output_.writeInt32(6, this.sendtype);
/*  301 */       _output_.writeBytes(7, ByteString.copyFrom(this.noticetitle, "UTF-16LE"));
/*  302 */       _output_.writeBytes(8, ByteString.copyFrom(this.noticecontent, "UTF-16LE"));
/*  303 */       _output_.writeBytes(9, ByteString.copyFrom(this.pictureurl, "UTF-16LE"));
/*  304 */       _output_.writeInt64(10, this.starttime);
/*  305 */       _output_.writeInt64(11, this.endtime);
/*  306 */       _output_.writeInt32(12, this.minopenserverdays);
/*  307 */       _output_.writeInt32(13, this.maxopenserverdays);
/*  308 */       _output_.writeInt32(14, this.mincreatroledays);
/*  309 */       _output_.writeInt32(15, this.maxcreatroledays);
/*  310 */       _output_.writeInt32(16, this.minrolelevel);
/*  311 */       _output_.writeInt32(17, this.maxrolelevel);
/*  312 */       _output_.writeInt64(18, this.minsaveamt);
/*  313 */       _output_.writeInt64(19, this.maxsaveamt);
/*  314 */       _output_.writeInt32(20, this.noticetag);
/*  315 */       _output_.writeBool(21, this.badge);
/*  316 */       _output_.writeInt32(22, this.noticesortid);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  320 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  322 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  328 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  331 */       boolean done = false;
/*  332 */       while (!done)
/*      */       {
/*  334 */         int tag = _input_.readTag();
/*  335 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  339 */           done = true;
/*  340 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  344 */           this.noticetype = _input_.readInt32();
/*  345 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  349 */           this.displaytype = _input_.readInt32();
/*  350 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  354 */           this.hreftype = _input_.readInt32();
/*  355 */           break;
/*      */         
/*      */ 
/*      */         case 34: 
/*  359 */           this.hreftext = _input_.readBytes().toString("UTF-16LE");
/*  360 */           break;
/*      */         
/*      */ 
/*      */         case 42: 
/*  364 */           this.hrefurl = _input_.readBytes().toString("UTF-16LE");
/*  365 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  369 */           this.sendtype = _input_.readInt32();
/*  370 */           break;
/*      */         
/*      */ 
/*      */         case 58: 
/*  374 */           this.noticetitle = _input_.readBytes().toString("UTF-16LE");
/*  375 */           break;
/*      */         
/*      */ 
/*      */         case 66: 
/*  379 */           this.noticecontent = _input_.readBytes().toString("UTF-16LE");
/*  380 */           break;
/*      */         
/*      */ 
/*      */         case 74: 
/*  384 */           this.pictureurl = _input_.readBytes().toString("UTF-16LE");
/*  385 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  389 */           this.starttime = _input_.readInt64();
/*  390 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  394 */           this.endtime = _input_.readInt64();
/*  395 */           break;
/*      */         
/*      */ 
/*      */         case 96: 
/*  399 */           this.minopenserverdays = _input_.readInt32();
/*  400 */           break;
/*      */         
/*      */ 
/*      */         case 104: 
/*  404 */           this.maxopenserverdays = _input_.readInt32();
/*  405 */           break;
/*      */         
/*      */ 
/*      */         case 112: 
/*  409 */           this.mincreatroledays = _input_.readInt32();
/*  410 */           break;
/*      */         
/*      */ 
/*      */         case 120: 
/*  414 */           this.maxcreatroledays = _input_.readInt32();
/*  415 */           break;
/*      */         
/*      */ 
/*      */         case 128: 
/*  419 */           this.minrolelevel = _input_.readInt32();
/*  420 */           break;
/*      */         
/*      */ 
/*      */         case 136: 
/*  424 */           this.maxrolelevel = _input_.readInt32();
/*  425 */           break;
/*      */         
/*      */ 
/*      */         case 144: 
/*  429 */           this.minsaveamt = _input_.readInt64();
/*  430 */           break;
/*      */         
/*      */ 
/*      */         case 152: 
/*  434 */           this.maxsaveamt = _input_.readInt64();
/*  435 */           break;
/*      */         
/*      */ 
/*      */         case 160: 
/*  439 */           this.noticetag = _input_.readInt32();
/*  440 */           break;
/*      */         
/*      */ 
/*      */         case 168: 
/*  444 */           this.badge = _input_.readBool();
/*  445 */           break;
/*      */         
/*      */ 
/*      */         case 176: 
/*  449 */           this.noticesortid = _input_.readInt32();
/*  450 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  454 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  456 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  465 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  469 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  471 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.IdipNoticeInfo copy()
/*      */   {
/*  477 */     _xdb_verify_unsafe_();
/*  478 */     return new IdipNoticeInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.IdipNoticeInfo toData()
/*      */   {
/*  484 */     _xdb_verify_unsafe_();
/*  485 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.IdipNoticeInfo toBean()
/*      */   {
/*  490 */     _xdb_verify_unsafe_();
/*  491 */     return new IdipNoticeInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.IdipNoticeInfo toDataIf()
/*      */   {
/*  497 */     _xdb_verify_unsafe_();
/*  498 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.IdipNoticeInfo toBeanIf()
/*      */   {
/*  503 */     _xdb_verify_unsafe_();
/*  504 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  510 */     _xdb_verify_unsafe_();
/*  511 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getNoticetype()
/*      */   {
/*  518 */     _xdb_verify_unsafe_();
/*  519 */     return this.noticetype;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDisplaytype()
/*      */   {
/*  526 */     _xdb_verify_unsafe_();
/*  527 */     return this.displaytype;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getHreftype()
/*      */   {
/*  534 */     _xdb_verify_unsafe_();
/*  535 */     return this.hreftype;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getHreftext()
/*      */   {
/*  542 */     _xdb_verify_unsafe_();
/*  543 */     return this.hreftext;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getHreftextOctets()
/*      */   {
/*  550 */     _xdb_verify_unsafe_();
/*  551 */     return Octets.wrap(getHreftext(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getHrefurl()
/*      */   {
/*  558 */     _xdb_verify_unsafe_();
/*  559 */     return this.hrefurl;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getHrefurlOctets()
/*      */   {
/*  566 */     _xdb_verify_unsafe_();
/*  567 */     return Octets.wrap(getHrefurl(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getSendtype()
/*      */   {
/*  574 */     _xdb_verify_unsafe_();
/*  575 */     return this.sendtype;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getNoticetitle()
/*      */   {
/*  582 */     _xdb_verify_unsafe_();
/*  583 */     return this.noticetitle;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getNoticetitleOctets()
/*      */   {
/*  590 */     _xdb_verify_unsafe_();
/*  591 */     return Octets.wrap(getNoticetitle(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getNoticecontent()
/*      */   {
/*  598 */     _xdb_verify_unsafe_();
/*  599 */     return this.noticecontent;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getNoticecontentOctets()
/*      */   {
/*  606 */     _xdb_verify_unsafe_();
/*  607 */     return Octets.wrap(getNoticecontent(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getPictureurl()
/*      */   {
/*  614 */     _xdb_verify_unsafe_();
/*  615 */     return this.pictureurl;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getPictureurlOctets()
/*      */   {
/*  622 */     _xdb_verify_unsafe_();
/*  623 */     return Octets.wrap(getPictureurl(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getStarttime()
/*      */   {
/*  630 */     _xdb_verify_unsafe_();
/*  631 */     return this.starttime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getEndtime()
/*      */   {
/*  638 */     _xdb_verify_unsafe_();
/*  639 */     return this.endtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMinopenserverdays()
/*      */   {
/*  646 */     _xdb_verify_unsafe_();
/*  647 */     return this.minopenserverdays;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMaxopenserverdays()
/*      */   {
/*  654 */     _xdb_verify_unsafe_();
/*  655 */     return this.maxopenserverdays;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMincreatroledays()
/*      */   {
/*  662 */     _xdb_verify_unsafe_();
/*  663 */     return this.mincreatroledays;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMaxcreatroledays()
/*      */   {
/*  670 */     _xdb_verify_unsafe_();
/*  671 */     return this.maxcreatroledays;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMinrolelevel()
/*      */   {
/*  678 */     _xdb_verify_unsafe_();
/*  679 */     return this.minrolelevel;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMaxrolelevel()
/*      */   {
/*  686 */     _xdb_verify_unsafe_();
/*  687 */     return this.maxrolelevel;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getMinsaveamt()
/*      */   {
/*  694 */     _xdb_verify_unsafe_();
/*  695 */     return this.minsaveamt;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getMaxsaveamt()
/*      */   {
/*  702 */     _xdb_verify_unsafe_();
/*  703 */     return this.maxsaveamt;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getNoticetag()
/*      */   {
/*  710 */     _xdb_verify_unsafe_();
/*  711 */     return this.noticetag;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getBadge()
/*      */   {
/*  718 */     _xdb_verify_unsafe_();
/*  719 */     return this.badge;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getNoticesortid()
/*      */   {
/*  726 */     _xdb_verify_unsafe_();
/*  727 */     return this.noticesortid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNoticetype(int _v_)
/*      */   {
/*  734 */     _xdb_verify_unsafe_();
/*  735 */     Logs.logIf(new LogKey(this, "noticetype")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  739 */         new LogInt(this, IdipNoticeInfo.this.noticetype)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  743 */             IdipNoticeInfo.this.noticetype = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  747 */     });
/*  748 */     this.noticetype = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDisplaytype(int _v_)
/*      */   {
/*  755 */     _xdb_verify_unsafe_();
/*  756 */     Logs.logIf(new LogKey(this, "displaytype")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  760 */         new LogInt(this, IdipNoticeInfo.this.displaytype)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  764 */             IdipNoticeInfo.this.displaytype = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  768 */     });
/*  769 */     this.displaytype = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHreftype(int _v_)
/*      */   {
/*  776 */     _xdb_verify_unsafe_();
/*  777 */     Logs.logIf(new LogKey(this, "hreftype")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  781 */         new LogInt(this, IdipNoticeInfo.this.hreftype)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  785 */             IdipNoticeInfo.this.hreftype = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  789 */     });
/*  790 */     this.hreftype = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHreftext(String _v_)
/*      */   {
/*  797 */     _xdb_verify_unsafe_();
/*  798 */     if (null == _v_)
/*  799 */       throw new NullPointerException();
/*  800 */     Logs.logIf(new LogKey(this, "hreftext")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  804 */         new LogString(this, IdipNoticeInfo.this.hreftext)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  808 */             IdipNoticeInfo.this.hreftext = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  812 */     });
/*  813 */     this.hreftext = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHreftextOctets(Octets _v_)
/*      */   {
/*  820 */     _xdb_verify_unsafe_();
/*  821 */     setHreftext(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHrefurl(String _v_)
/*      */   {
/*  828 */     _xdb_verify_unsafe_();
/*  829 */     if (null == _v_)
/*  830 */       throw new NullPointerException();
/*  831 */     Logs.logIf(new LogKey(this, "hrefurl")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  835 */         new LogString(this, IdipNoticeInfo.this.hrefurl)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  839 */             IdipNoticeInfo.this.hrefurl = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  843 */     });
/*  844 */     this.hrefurl = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHrefurlOctets(Octets _v_)
/*      */   {
/*  851 */     _xdb_verify_unsafe_();
/*  852 */     setHrefurl(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSendtype(int _v_)
/*      */   {
/*  859 */     _xdb_verify_unsafe_();
/*  860 */     Logs.logIf(new LogKey(this, "sendtype")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  864 */         new LogInt(this, IdipNoticeInfo.this.sendtype)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  868 */             IdipNoticeInfo.this.sendtype = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  872 */     });
/*  873 */     this.sendtype = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNoticetitle(String _v_)
/*      */   {
/*  880 */     _xdb_verify_unsafe_();
/*  881 */     if (null == _v_)
/*  882 */       throw new NullPointerException();
/*  883 */     Logs.logIf(new LogKey(this, "noticetitle")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  887 */         new LogString(this, IdipNoticeInfo.this.noticetitle)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  891 */             IdipNoticeInfo.this.noticetitle = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  895 */     });
/*  896 */     this.noticetitle = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNoticetitleOctets(Octets _v_)
/*      */   {
/*  903 */     _xdb_verify_unsafe_();
/*  904 */     setNoticetitle(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNoticecontent(String _v_)
/*      */   {
/*  911 */     _xdb_verify_unsafe_();
/*  912 */     if (null == _v_)
/*  913 */       throw new NullPointerException();
/*  914 */     Logs.logIf(new LogKey(this, "noticecontent")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  918 */         new LogString(this, IdipNoticeInfo.this.noticecontent)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  922 */             IdipNoticeInfo.this.noticecontent = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  926 */     });
/*  927 */     this.noticecontent = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNoticecontentOctets(Octets _v_)
/*      */   {
/*  934 */     _xdb_verify_unsafe_();
/*  935 */     setNoticecontent(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPictureurl(String _v_)
/*      */   {
/*  942 */     _xdb_verify_unsafe_();
/*  943 */     if (null == _v_)
/*  944 */       throw new NullPointerException();
/*  945 */     Logs.logIf(new LogKey(this, "pictureurl")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  949 */         new LogString(this, IdipNoticeInfo.this.pictureurl)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  953 */             IdipNoticeInfo.this.pictureurl = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  957 */     });
/*  958 */     this.pictureurl = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPictureurlOctets(Octets _v_)
/*      */   {
/*  965 */     _xdb_verify_unsafe_();
/*  966 */     setPictureurl(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStarttime(long _v_)
/*      */   {
/*  973 */     _xdb_verify_unsafe_();
/*  974 */     Logs.logIf(new LogKey(this, "starttime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  978 */         new LogLong(this, IdipNoticeInfo.this.starttime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  982 */             IdipNoticeInfo.this.starttime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  986 */     });
/*  987 */     this.starttime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setEndtime(long _v_)
/*      */   {
/*  994 */     _xdb_verify_unsafe_();
/*  995 */     Logs.logIf(new LogKey(this, "endtime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  999 */         new LogLong(this, IdipNoticeInfo.this.endtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1003 */             IdipNoticeInfo.this.endtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1007 */     });
/* 1008 */     this.endtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMinopenserverdays(int _v_)
/*      */   {
/* 1015 */     _xdb_verify_unsafe_();
/* 1016 */     Logs.logIf(new LogKey(this, "minopenserverdays")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1020 */         new LogInt(this, IdipNoticeInfo.this.minopenserverdays)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1024 */             IdipNoticeInfo.this.minopenserverdays = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1028 */     });
/* 1029 */     this.minopenserverdays = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMaxopenserverdays(int _v_)
/*      */   {
/* 1036 */     _xdb_verify_unsafe_();
/* 1037 */     Logs.logIf(new LogKey(this, "maxopenserverdays")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1041 */         new LogInt(this, IdipNoticeInfo.this.maxopenserverdays)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1045 */             IdipNoticeInfo.this.maxopenserverdays = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1049 */     });
/* 1050 */     this.maxopenserverdays = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMincreatroledays(int _v_)
/*      */   {
/* 1057 */     _xdb_verify_unsafe_();
/* 1058 */     Logs.logIf(new LogKey(this, "mincreatroledays")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1062 */         new LogInt(this, IdipNoticeInfo.this.mincreatroledays)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1066 */             IdipNoticeInfo.this.mincreatroledays = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1070 */     });
/* 1071 */     this.mincreatroledays = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMaxcreatroledays(int _v_)
/*      */   {
/* 1078 */     _xdb_verify_unsafe_();
/* 1079 */     Logs.logIf(new LogKey(this, "maxcreatroledays")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1083 */         new LogInt(this, IdipNoticeInfo.this.maxcreatroledays)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1087 */             IdipNoticeInfo.this.maxcreatroledays = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1091 */     });
/* 1092 */     this.maxcreatroledays = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMinrolelevel(int _v_)
/*      */   {
/* 1099 */     _xdb_verify_unsafe_();
/* 1100 */     Logs.logIf(new LogKey(this, "minrolelevel")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1104 */         new LogInt(this, IdipNoticeInfo.this.minrolelevel)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1108 */             IdipNoticeInfo.this.minrolelevel = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1112 */     });
/* 1113 */     this.minrolelevel = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMaxrolelevel(int _v_)
/*      */   {
/* 1120 */     _xdb_verify_unsafe_();
/* 1121 */     Logs.logIf(new LogKey(this, "maxrolelevel")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1125 */         new LogInt(this, IdipNoticeInfo.this.maxrolelevel)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1129 */             IdipNoticeInfo.this.maxrolelevel = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1133 */     });
/* 1134 */     this.maxrolelevel = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMinsaveamt(long _v_)
/*      */   {
/* 1141 */     _xdb_verify_unsafe_();
/* 1142 */     Logs.logIf(new LogKey(this, "minsaveamt")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1146 */         new LogLong(this, IdipNoticeInfo.this.minsaveamt)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1150 */             IdipNoticeInfo.this.minsaveamt = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1154 */     });
/* 1155 */     this.minsaveamt = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMaxsaveamt(long _v_)
/*      */   {
/* 1162 */     _xdb_verify_unsafe_();
/* 1163 */     Logs.logIf(new LogKey(this, "maxsaveamt")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1167 */         new LogLong(this, IdipNoticeInfo.this.maxsaveamt)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1171 */             IdipNoticeInfo.this.maxsaveamt = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1175 */     });
/* 1176 */     this.maxsaveamt = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNoticetag(int _v_)
/*      */   {
/* 1183 */     _xdb_verify_unsafe_();
/* 1184 */     Logs.logIf(new LogKey(this, "noticetag")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1188 */         new LogInt(this, IdipNoticeInfo.this.noticetag)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1192 */             IdipNoticeInfo.this.noticetag = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1196 */     });
/* 1197 */     this.noticetag = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBadge(boolean _v_)
/*      */   {
/* 1204 */     _xdb_verify_unsafe_();
/* 1205 */     Logs.logIf(new LogKey(this, "badge")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1209 */         new LogObject(this, Boolean.valueOf(IdipNoticeInfo.this.badge))
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1213 */             IdipNoticeInfo.this.badge = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/* 1217 */     });
/* 1218 */     this.badge = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNoticesortid(int _v_)
/*      */   {
/* 1225 */     _xdb_verify_unsafe_();
/* 1226 */     Logs.logIf(new LogKey(this, "noticesortid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1230 */         new LogInt(this, IdipNoticeInfo.this.noticesortid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1234 */             IdipNoticeInfo.this.noticesortid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1238 */     });
/* 1239 */     this.noticesortid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/* 1245 */     _xdb_verify_unsafe_();
/* 1246 */     IdipNoticeInfo _o_ = null;
/* 1247 */     if ((_o1_ instanceof IdipNoticeInfo)) { _o_ = (IdipNoticeInfo)_o1_;
/* 1248 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 1249 */       return false;
/* 1250 */     if (this.noticetype != _o_.noticetype) return false;
/* 1251 */     if (this.displaytype != _o_.displaytype) return false;
/* 1252 */     if (this.hreftype != _o_.hreftype) return false;
/* 1253 */     if (!this.hreftext.equals(_o_.hreftext)) return false;
/* 1254 */     if (!this.hrefurl.equals(_o_.hrefurl)) return false;
/* 1255 */     if (this.sendtype != _o_.sendtype) return false;
/* 1256 */     if (!this.noticetitle.equals(_o_.noticetitle)) return false;
/* 1257 */     if (!this.noticecontent.equals(_o_.noticecontent)) return false;
/* 1258 */     if (!this.pictureurl.equals(_o_.pictureurl)) return false;
/* 1259 */     if (this.starttime != _o_.starttime) return false;
/* 1260 */     if (this.endtime != _o_.endtime) return false;
/* 1261 */     if (this.minopenserverdays != _o_.minopenserverdays) return false;
/* 1262 */     if (this.maxopenserverdays != _o_.maxopenserverdays) return false;
/* 1263 */     if (this.mincreatroledays != _o_.mincreatroledays) return false;
/* 1264 */     if (this.maxcreatroledays != _o_.maxcreatroledays) return false;
/* 1265 */     if (this.minrolelevel != _o_.minrolelevel) return false;
/* 1266 */     if (this.maxrolelevel != _o_.maxrolelevel) return false;
/* 1267 */     if (this.minsaveamt != _o_.minsaveamt) return false;
/* 1268 */     if (this.maxsaveamt != _o_.maxsaveamt) return false;
/* 1269 */     if (this.noticetag != _o_.noticetag) return false;
/* 1270 */     if (this.badge != _o_.badge) return false;
/* 1271 */     if (this.noticesortid != _o_.noticesortid) return false;
/* 1272 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/* 1278 */     _xdb_verify_unsafe_();
/* 1279 */     int _h_ = 0;
/* 1280 */     _h_ += this.noticetype;
/* 1281 */     _h_ += this.displaytype;
/* 1282 */     _h_ += this.hreftype;
/* 1283 */     _h_ += this.hreftext.hashCode();
/* 1284 */     _h_ += this.hrefurl.hashCode();
/* 1285 */     _h_ += this.sendtype;
/* 1286 */     _h_ += this.noticetitle.hashCode();
/* 1287 */     _h_ += this.noticecontent.hashCode();
/* 1288 */     _h_ += this.pictureurl.hashCode();
/* 1289 */     _h_ = (int)(_h_ + this.starttime);
/* 1290 */     _h_ = (int)(_h_ + this.endtime);
/* 1291 */     _h_ += this.minopenserverdays;
/* 1292 */     _h_ += this.maxopenserverdays;
/* 1293 */     _h_ += this.mincreatroledays;
/* 1294 */     _h_ += this.maxcreatroledays;
/* 1295 */     _h_ += this.minrolelevel;
/* 1296 */     _h_ += this.maxrolelevel;
/* 1297 */     _h_ = (int)(_h_ + this.minsaveamt);
/* 1298 */     _h_ = (int)(_h_ + this.maxsaveamt);
/* 1299 */     _h_ += this.noticetag;
/* 1300 */     _h_ += (this.badge ? 1231 : 1237);
/* 1301 */     _h_ += this.noticesortid;
/* 1302 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/* 1308 */     _xdb_verify_unsafe_();
/* 1309 */     StringBuilder _sb_ = new StringBuilder();
/* 1310 */     _sb_.append("(");
/* 1311 */     _sb_.append(this.noticetype);
/* 1312 */     _sb_.append(",");
/* 1313 */     _sb_.append(this.displaytype);
/* 1314 */     _sb_.append(",");
/* 1315 */     _sb_.append(this.hreftype);
/* 1316 */     _sb_.append(",");
/* 1317 */     _sb_.append("'").append(this.hreftext).append("'");
/* 1318 */     _sb_.append(",");
/* 1319 */     _sb_.append("'").append(this.hrefurl).append("'");
/* 1320 */     _sb_.append(",");
/* 1321 */     _sb_.append(this.sendtype);
/* 1322 */     _sb_.append(",");
/* 1323 */     _sb_.append("'").append(this.noticetitle).append("'");
/* 1324 */     _sb_.append(",");
/* 1325 */     _sb_.append("'").append(this.noticecontent).append("'");
/* 1326 */     _sb_.append(",");
/* 1327 */     _sb_.append("'").append(this.pictureurl).append("'");
/* 1328 */     _sb_.append(",");
/* 1329 */     _sb_.append(this.starttime);
/* 1330 */     _sb_.append(",");
/* 1331 */     _sb_.append(this.endtime);
/* 1332 */     _sb_.append(",");
/* 1333 */     _sb_.append(this.minopenserverdays);
/* 1334 */     _sb_.append(",");
/* 1335 */     _sb_.append(this.maxopenserverdays);
/* 1336 */     _sb_.append(",");
/* 1337 */     _sb_.append(this.mincreatroledays);
/* 1338 */     _sb_.append(",");
/* 1339 */     _sb_.append(this.maxcreatroledays);
/* 1340 */     _sb_.append(",");
/* 1341 */     _sb_.append(this.minrolelevel);
/* 1342 */     _sb_.append(",");
/* 1343 */     _sb_.append(this.maxrolelevel);
/* 1344 */     _sb_.append(",");
/* 1345 */     _sb_.append(this.minsaveamt);
/* 1346 */     _sb_.append(",");
/* 1347 */     _sb_.append(this.maxsaveamt);
/* 1348 */     _sb_.append(",");
/* 1349 */     _sb_.append(this.noticetag);
/* 1350 */     _sb_.append(",");
/* 1351 */     _sb_.append(this.badge);
/* 1352 */     _sb_.append(",");
/* 1353 */     _sb_.append(this.noticesortid);
/* 1354 */     _sb_.append(")");
/* 1355 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public Listenable newListenable()
/*      */   {
/* 1361 */     ListenableBean lb = new ListenableBean();
/* 1362 */     lb.add(new ListenableChanged().setVarName("noticetype"));
/* 1363 */     lb.add(new ListenableChanged().setVarName("displaytype"));
/* 1364 */     lb.add(new ListenableChanged().setVarName("hreftype"));
/* 1365 */     lb.add(new ListenableChanged().setVarName("hreftext"));
/* 1366 */     lb.add(new ListenableChanged().setVarName("hrefurl"));
/* 1367 */     lb.add(new ListenableChanged().setVarName("sendtype"));
/* 1368 */     lb.add(new ListenableChanged().setVarName("noticetitle"));
/* 1369 */     lb.add(new ListenableChanged().setVarName("noticecontent"));
/* 1370 */     lb.add(new ListenableChanged().setVarName("pictureurl"));
/* 1371 */     lb.add(new ListenableChanged().setVarName("starttime"));
/* 1372 */     lb.add(new ListenableChanged().setVarName("endtime"));
/* 1373 */     lb.add(new ListenableChanged().setVarName("minopenserverdays"));
/* 1374 */     lb.add(new ListenableChanged().setVarName("maxopenserverdays"));
/* 1375 */     lb.add(new ListenableChanged().setVarName("mincreatroledays"));
/* 1376 */     lb.add(new ListenableChanged().setVarName("maxcreatroledays"));
/* 1377 */     lb.add(new ListenableChanged().setVarName("minrolelevel"));
/* 1378 */     lb.add(new ListenableChanged().setVarName("maxrolelevel"));
/* 1379 */     lb.add(new ListenableChanged().setVarName("minsaveamt"));
/* 1380 */     lb.add(new ListenableChanged().setVarName("maxsaveamt"));
/* 1381 */     lb.add(new ListenableChanged().setVarName("noticetag"));
/* 1382 */     lb.add(new ListenableChanged().setVarName("badge"));
/* 1383 */     lb.add(new ListenableChanged().setVarName("noticesortid"));
/* 1384 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.IdipNoticeInfo {
/*      */     private Const() {}
/*      */     
/*      */     IdipNoticeInfo nThis() {
/* 1391 */       return IdipNoticeInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1397 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.IdipNoticeInfo copy()
/*      */     {
/* 1403 */       return IdipNoticeInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.IdipNoticeInfo toData()
/*      */     {
/* 1409 */       return IdipNoticeInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.IdipNoticeInfo toBean()
/*      */     {
/* 1414 */       return IdipNoticeInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.IdipNoticeInfo toDataIf()
/*      */     {
/* 1420 */       return IdipNoticeInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.IdipNoticeInfo toBeanIf()
/*      */     {
/* 1425 */       return IdipNoticeInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNoticetype()
/*      */     {
/* 1432 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1433 */       return IdipNoticeInfo.this.noticetype;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDisplaytype()
/*      */     {
/* 1440 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1441 */       return IdipNoticeInfo.this.displaytype;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHreftype()
/*      */     {
/* 1448 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1449 */       return IdipNoticeInfo.this.hreftype;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getHreftext()
/*      */     {
/* 1456 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1457 */       return IdipNoticeInfo.this.hreftext;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getHreftextOctets()
/*      */     {
/* 1464 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1465 */       return IdipNoticeInfo.this.getHreftextOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getHrefurl()
/*      */     {
/* 1472 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1473 */       return IdipNoticeInfo.this.hrefurl;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getHrefurlOctets()
/*      */     {
/* 1480 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1481 */       return IdipNoticeInfo.this.getHrefurlOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSendtype()
/*      */     {
/* 1488 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1489 */       return IdipNoticeInfo.this.sendtype;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getNoticetitle()
/*      */     {
/* 1496 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1497 */       return IdipNoticeInfo.this.noticetitle;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getNoticetitleOctets()
/*      */     {
/* 1504 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1505 */       return IdipNoticeInfo.this.getNoticetitleOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getNoticecontent()
/*      */     {
/* 1512 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1513 */       return IdipNoticeInfo.this.noticecontent;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getNoticecontentOctets()
/*      */     {
/* 1520 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1521 */       return IdipNoticeInfo.this.getNoticecontentOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getPictureurl()
/*      */     {
/* 1528 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1529 */       return IdipNoticeInfo.this.pictureurl;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getPictureurlOctets()
/*      */     {
/* 1536 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1537 */       return IdipNoticeInfo.this.getPictureurlOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStarttime()
/*      */     {
/* 1544 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1545 */       return IdipNoticeInfo.this.starttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEndtime()
/*      */     {
/* 1552 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1553 */       return IdipNoticeInfo.this.endtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMinopenserverdays()
/*      */     {
/* 1560 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1561 */       return IdipNoticeInfo.this.minopenserverdays;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMaxopenserverdays()
/*      */     {
/* 1568 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1569 */       return IdipNoticeInfo.this.maxopenserverdays;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMincreatroledays()
/*      */     {
/* 1576 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1577 */       return IdipNoticeInfo.this.mincreatroledays;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMaxcreatroledays()
/*      */     {
/* 1584 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1585 */       return IdipNoticeInfo.this.maxcreatroledays;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMinrolelevel()
/*      */     {
/* 1592 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1593 */       return IdipNoticeInfo.this.minrolelevel;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMaxrolelevel()
/*      */     {
/* 1600 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1601 */       return IdipNoticeInfo.this.maxrolelevel;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMinsaveamt()
/*      */     {
/* 1608 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1609 */       return IdipNoticeInfo.this.minsaveamt;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMaxsaveamt()
/*      */     {
/* 1616 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1617 */       return IdipNoticeInfo.this.maxsaveamt;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNoticetag()
/*      */     {
/* 1624 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1625 */       return IdipNoticeInfo.this.noticetag;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getBadge()
/*      */     {
/* 1632 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1633 */       return IdipNoticeInfo.this.badge;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNoticesortid()
/*      */     {
/* 1640 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1641 */       return IdipNoticeInfo.this.noticesortid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNoticetype(int _v_)
/*      */     {
/* 1648 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1649 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDisplaytype(int _v_)
/*      */     {
/* 1656 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1657 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHreftype(int _v_)
/*      */     {
/* 1664 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1665 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHreftext(String _v_)
/*      */     {
/* 1672 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1673 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHreftextOctets(Octets _v_)
/*      */     {
/* 1680 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1681 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHrefurl(String _v_)
/*      */     {
/* 1688 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1689 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHrefurlOctets(Octets _v_)
/*      */     {
/* 1696 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1697 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSendtype(int _v_)
/*      */     {
/* 1704 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1705 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNoticetitle(String _v_)
/*      */     {
/* 1712 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1713 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNoticetitleOctets(Octets _v_)
/*      */     {
/* 1720 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1721 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNoticecontent(String _v_)
/*      */     {
/* 1728 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1729 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNoticecontentOctets(Octets _v_)
/*      */     {
/* 1736 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1737 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPictureurl(String _v_)
/*      */     {
/* 1744 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1745 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPictureurlOctets(Octets _v_)
/*      */     {
/* 1752 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1753 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStarttime(long _v_)
/*      */     {
/* 1760 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1761 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEndtime(long _v_)
/*      */     {
/* 1768 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1769 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMinopenserverdays(int _v_)
/*      */     {
/* 1776 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1777 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMaxopenserverdays(int _v_)
/*      */     {
/* 1784 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1785 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMincreatroledays(int _v_)
/*      */     {
/* 1792 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1793 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMaxcreatroledays(int _v_)
/*      */     {
/* 1800 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1801 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMinrolelevel(int _v_)
/*      */     {
/* 1808 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1809 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMaxrolelevel(int _v_)
/*      */     {
/* 1816 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1817 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMinsaveamt(long _v_)
/*      */     {
/* 1824 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1825 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMaxsaveamt(long _v_)
/*      */     {
/* 1832 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1833 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNoticetag(int _v_)
/*      */     {
/* 1840 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1841 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBadge(boolean _v_)
/*      */     {
/* 1848 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1849 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNoticesortid(int _v_)
/*      */     {
/* 1856 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1857 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 1863 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1864 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1870 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1871 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1877 */       return IdipNoticeInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1883 */       return IdipNoticeInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 1889 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1890 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1896 */       return IdipNoticeInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1902 */       return IdipNoticeInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1908 */       IdipNoticeInfo.this._xdb_verify_unsafe_();
/* 1909 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 1915 */       return IdipNoticeInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1921 */       return IdipNoticeInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1927 */       return IdipNoticeInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1933 */       return IdipNoticeInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1939 */       return IdipNoticeInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1945 */       return IdipNoticeInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1951 */       return IdipNoticeInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.IdipNoticeInfo
/*      */   {
/*      */     private int noticetype;
/*      */     
/*      */     private int displaytype;
/*      */     
/*      */     private int hreftype;
/*      */     
/*      */     private String hreftext;
/*      */     
/*      */     private String hrefurl;
/*      */     
/*      */     private int sendtype;
/*      */     
/*      */     private String noticetitle;
/*      */     
/*      */     private String noticecontent;
/*      */     
/*      */     private String pictureurl;
/*      */     
/*      */     private long starttime;
/*      */     
/*      */     private long endtime;
/*      */     
/*      */     private int minopenserverdays;
/*      */     
/*      */     private int maxopenserverdays;
/*      */     
/*      */     private int mincreatroledays;
/*      */     
/*      */     private int maxcreatroledays;
/*      */     
/*      */     private int minrolelevel;
/*      */     
/*      */     private int maxrolelevel;
/*      */     
/*      */     private long minsaveamt;
/*      */     
/*      */     private long maxsaveamt;
/*      */     
/*      */     private int noticetag;
/*      */     
/*      */     private boolean badge;
/*      */     
/*      */     private int noticesortid;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 2005 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 2010 */       this.hreftext = "";
/* 2011 */       this.hrefurl = "";
/* 2012 */       this.noticetitle = "";
/* 2013 */       this.noticecontent = "";
/* 2014 */       this.pictureurl = "";
/*      */     }
/*      */     
/*      */     Data(xbean.IdipNoticeInfo _o1_)
/*      */     {
/* 2019 */       if ((_o1_ instanceof IdipNoticeInfo)) { assign((IdipNoticeInfo)_o1_);
/* 2020 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 2021 */       } else if ((_o1_ instanceof IdipNoticeInfo.Const)) assign(((IdipNoticeInfo.Const)_o1_).nThis()); else {
/* 2022 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(IdipNoticeInfo _o_) {
/* 2027 */       this.noticetype = _o_.noticetype;
/* 2028 */       this.displaytype = _o_.displaytype;
/* 2029 */       this.hreftype = _o_.hreftype;
/* 2030 */       this.hreftext = _o_.hreftext;
/* 2031 */       this.hrefurl = _o_.hrefurl;
/* 2032 */       this.sendtype = _o_.sendtype;
/* 2033 */       this.noticetitle = _o_.noticetitle;
/* 2034 */       this.noticecontent = _o_.noticecontent;
/* 2035 */       this.pictureurl = _o_.pictureurl;
/* 2036 */       this.starttime = _o_.starttime;
/* 2037 */       this.endtime = _o_.endtime;
/* 2038 */       this.minopenserverdays = _o_.minopenserverdays;
/* 2039 */       this.maxopenserverdays = _o_.maxopenserverdays;
/* 2040 */       this.mincreatroledays = _o_.mincreatroledays;
/* 2041 */       this.maxcreatroledays = _o_.maxcreatroledays;
/* 2042 */       this.minrolelevel = _o_.minrolelevel;
/* 2043 */       this.maxrolelevel = _o_.maxrolelevel;
/* 2044 */       this.minsaveamt = _o_.minsaveamt;
/* 2045 */       this.maxsaveamt = _o_.maxsaveamt;
/* 2046 */       this.noticetag = _o_.noticetag;
/* 2047 */       this.badge = _o_.badge;
/* 2048 */       this.noticesortid = _o_.noticesortid;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 2053 */       this.noticetype = _o_.noticetype;
/* 2054 */       this.displaytype = _o_.displaytype;
/* 2055 */       this.hreftype = _o_.hreftype;
/* 2056 */       this.hreftext = _o_.hreftext;
/* 2057 */       this.hrefurl = _o_.hrefurl;
/* 2058 */       this.sendtype = _o_.sendtype;
/* 2059 */       this.noticetitle = _o_.noticetitle;
/* 2060 */       this.noticecontent = _o_.noticecontent;
/* 2061 */       this.pictureurl = _o_.pictureurl;
/* 2062 */       this.starttime = _o_.starttime;
/* 2063 */       this.endtime = _o_.endtime;
/* 2064 */       this.minopenserverdays = _o_.minopenserverdays;
/* 2065 */       this.maxopenserverdays = _o_.maxopenserverdays;
/* 2066 */       this.mincreatroledays = _o_.mincreatroledays;
/* 2067 */       this.maxcreatroledays = _o_.maxcreatroledays;
/* 2068 */       this.minrolelevel = _o_.minrolelevel;
/* 2069 */       this.maxrolelevel = _o_.maxrolelevel;
/* 2070 */       this.minsaveamt = _o_.minsaveamt;
/* 2071 */       this.maxsaveamt = _o_.maxsaveamt;
/* 2072 */       this.noticetag = _o_.noticetag;
/* 2073 */       this.badge = _o_.badge;
/* 2074 */       this.noticesortid = _o_.noticesortid;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 2080 */       _os_.marshal(this.noticetype);
/* 2081 */       _os_.marshal(this.displaytype);
/* 2082 */       _os_.marshal(this.hreftype);
/* 2083 */       _os_.marshal(this.hreftext, "UTF-16LE");
/* 2084 */       _os_.marshal(this.hrefurl, "UTF-16LE");
/* 2085 */       _os_.marshal(this.sendtype);
/* 2086 */       _os_.marshal(this.noticetitle, "UTF-16LE");
/* 2087 */       _os_.marshal(this.noticecontent, "UTF-16LE");
/* 2088 */       _os_.marshal(this.pictureurl, "UTF-16LE");
/* 2089 */       _os_.marshal(this.starttime);
/* 2090 */       _os_.marshal(this.endtime);
/* 2091 */       _os_.marshal(this.minopenserverdays);
/* 2092 */       _os_.marshal(this.maxopenserverdays);
/* 2093 */       _os_.marshal(this.mincreatroledays);
/* 2094 */       _os_.marshal(this.maxcreatroledays);
/* 2095 */       _os_.marshal(this.minrolelevel);
/* 2096 */       _os_.marshal(this.maxrolelevel);
/* 2097 */       _os_.marshal(this.minsaveamt);
/* 2098 */       _os_.marshal(this.maxsaveamt);
/* 2099 */       _os_.marshal(this.noticetag);
/* 2100 */       _os_.marshal(this.badge);
/* 2101 */       _os_.marshal(this.noticesortid);
/* 2102 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 2108 */       this.noticetype = _os_.unmarshal_int();
/* 2109 */       this.displaytype = _os_.unmarshal_int();
/* 2110 */       this.hreftype = _os_.unmarshal_int();
/* 2111 */       this.hreftext = _os_.unmarshal_String("UTF-16LE");
/* 2112 */       this.hrefurl = _os_.unmarshal_String("UTF-16LE");
/* 2113 */       this.sendtype = _os_.unmarshal_int();
/* 2114 */       this.noticetitle = _os_.unmarshal_String("UTF-16LE");
/* 2115 */       this.noticecontent = _os_.unmarshal_String("UTF-16LE");
/* 2116 */       this.pictureurl = _os_.unmarshal_String("UTF-16LE");
/* 2117 */       this.starttime = _os_.unmarshal_long();
/* 2118 */       this.endtime = _os_.unmarshal_long();
/* 2119 */       this.minopenserverdays = _os_.unmarshal_int();
/* 2120 */       this.maxopenserverdays = _os_.unmarshal_int();
/* 2121 */       this.mincreatroledays = _os_.unmarshal_int();
/* 2122 */       this.maxcreatroledays = _os_.unmarshal_int();
/* 2123 */       this.minrolelevel = _os_.unmarshal_int();
/* 2124 */       this.maxrolelevel = _os_.unmarshal_int();
/* 2125 */       this.minsaveamt = _os_.unmarshal_long();
/* 2126 */       this.maxsaveamt = _os_.unmarshal_long();
/* 2127 */       this.noticetag = _os_.unmarshal_int();
/* 2128 */       this.badge = _os_.unmarshal_boolean();
/* 2129 */       this.noticesortid = _os_.unmarshal_int();
/* 2130 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 2136 */       int _size_ = 0;
/* 2137 */       _size_ += CodedOutputStream.computeInt32Size(1, this.noticetype);
/* 2138 */       _size_ += CodedOutputStream.computeInt32Size(2, this.displaytype);
/* 2139 */       _size_ += CodedOutputStream.computeInt32Size(3, this.hreftype);
/*      */       try
/*      */       {
/* 2142 */         _size_ += CodedOutputStream.computeBytesSize(4, ByteString.copyFrom(this.hreftext, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 2146 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */       try
/*      */       {
/* 2150 */         _size_ += CodedOutputStream.computeBytesSize(5, ByteString.copyFrom(this.hrefurl, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 2154 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 2156 */       _size_ += CodedOutputStream.computeInt32Size(6, this.sendtype);
/*      */       try
/*      */       {
/* 2159 */         _size_ += CodedOutputStream.computeBytesSize(7, ByteString.copyFrom(this.noticetitle, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 2163 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */       try
/*      */       {
/* 2167 */         _size_ += CodedOutputStream.computeBytesSize(8, ByteString.copyFrom(this.noticecontent, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 2171 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */       try
/*      */       {
/* 2175 */         _size_ += CodedOutputStream.computeBytesSize(9, ByteString.copyFrom(this.pictureurl, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 2179 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 2181 */       _size_ += CodedOutputStream.computeInt64Size(10, this.starttime);
/* 2182 */       _size_ += CodedOutputStream.computeInt64Size(11, this.endtime);
/* 2183 */       _size_ += CodedOutputStream.computeInt32Size(12, this.minopenserverdays);
/* 2184 */       _size_ += CodedOutputStream.computeInt32Size(13, this.maxopenserverdays);
/* 2185 */       _size_ += CodedOutputStream.computeInt32Size(14, this.mincreatroledays);
/* 2186 */       _size_ += CodedOutputStream.computeInt32Size(15, this.maxcreatroledays);
/* 2187 */       _size_ += CodedOutputStream.computeInt32Size(16, this.minrolelevel);
/* 2188 */       _size_ += CodedOutputStream.computeInt32Size(17, this.maxrolelevel);
/* 2189 */       _size_ += CodedOutputStream.computeInt64Size(18, this.minsaveamt);
/* 2190 */       _size_ += CodedOutputStream.computeInt64Size(19, this.maxsaveamt);
/* 2191 */       _size_ += CodedOutputStream.computeInt32Size(20, this.noticetag);
/* 2192 */       _size_ += CodedOutputStream.computeBoolSize(21, this.badge);
/* 2193 */       _size_ += CodedOutputStream.computeInt32Size(22, this.noticesortid);
/* 2194 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 2202 */         _output_.writeInt32(1, this.noticetype);
/* 2203 */         _output_.writeInt32(2, this.displaytype);
/* 2204 */         _output_.writeInt32(3, this.hreftype);
/* 2205 */         _output_.writeBytes(4, ByteString.copyFrom(this.hreftext, "UTF-16LE"));
/* 2206 */         _output_.writeBytes(5, ByteString.copyFrom(this.hrefurl, "UTF-16LE"));
/* 2207 */         _output_.writeInt32(6, this.sendtype);
/* 2208 */         _output_.writeBytes(7, ByteString.copyFrom(this.noticetitle, "UTF-16LE"));
/* 2209 */         _output_.writeBytes(8, ByteString.copyFrom(this.noticecontent, "UTF-16LE"));
/* 2210 */         _output_.writeBytes(9, ByteString.copyFrom(this.pictureurl, "UTF-16LE"));
/* 2211 */         _output_.writeInt64(10, this.starttime);
/* 2212 */         _output_.writeInt64(11, this.endtime);
/* 2213 */         _output_.writeInt32(12, this.minopenserverdays);
/* 2214 */         _output_.writeInt32(13, this.maxopenserverdays);
/* 2215 */         _output_.writeInt32(14, this.mincreatroledays);
/* 2216 */         _output_.writeInt32(15, this.maxcreatroledays);
/* 2217 */         _output_.writeInt32(16, this.minrolelevel);
/* 2218 */         _output_.writeInt32(17, this.maxrolelevel);
/* 2219 */         _output_.writeInt64(18, this.minsaveamt);
/* 2220 */         _output_.writeInt64(19, this.maxsaveamt);
/* 2221 */         _output_.writeInt32(20, this.noticetag);
/* 2222 */         _output_.writeBool(21, this.badge);
/* 2223 */         _output_.writeInt32(22, this.noticesortid);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 2227 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 2229 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 2237 */         boolean done = false;
/* 2238 */         while (!done)
/*      */         {
/* 2240 */           int tag = _input_.readTag();
/* 2241 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 2245 */             done = true;
/* 2246 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 2250 */             this.noticetype = _input_.readInt32();
/* 2251 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 2255 */             this.displaytype = _input_.readInt32();
/* 2256 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 2260 */             this.hreftype = _input_.readInt32();
/* 2261 */             break;
/*      */           
/*      */ 
/*      */           case 34: 
/* 2265 */             this.hreftext = _input_.readBytes().toString("UTF-16LE");
/* 2266 */             break;
/*      */           
/*      */ 
/*      */           case 42: 
/* 2270 */             this.hrefurl = _input_.readBytes().toString("UTF-16LE");
/* 2271 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 2275 */             this.sendtype = _input_.readInt32();
/* 2276 */             break;
/*      */           
/*      */ 
/*      */           case 58: 
/* 2280 */             this.noticetitle = _input_.readBytes().toString("UTF-16LE");
/* 2281 */             break;
/*      */           
/*      */ 
/*      */           case 66: 
/* 2285 */             this.noticecontent = _input_.readBytes().toString("UTF-16LE");
/* 2286 */             break;
/*      */           
/*      */ 
/*      */           case 74: 
/* 2290 */             this.pictureurl = _input_.readBytes().toString("UTF-16LE");
/* 2291 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 2295 */             this.starttime = _input_.readInt64();
/* 2296 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 2300 */             this.endtime = _input_.readInt64();
/* 2301 */             break;
/*      */           
/*      */ 
/*      */           case 96: 
/* 2305 */             this.minopenserverdays = _input_.readInt32();
/* 2306 */             break;
/*      */           
/*      */ 
/*      */           case 104: 
/* 2310 */             this.maxopenserverdays = _input_.readInt32();
/* 2311 */             break;
/*      */           
/*      */ 
/*      */           case 112: 
/* 2315 */             this.mincreatroledays = _input_.readInt32();
/* 2316 */             break;
/*      */           
/*      */ 
/*      */           case 120: 
/* 2320 */             this.maxcreatroledays = _input_.readInt32();
/* 2321 */             break;
/*      */           
/*      */ 
/*      */           case 128: 
/* 2325 */             this.minrolelevel = _input_.readInt32();
/* 2326 */             break;
/*      */           
/*      */ 
/*      */           case 136: 
/* 2330 */             this.maxrolelevel = _input_.readInt32();
/* 2331 */             break;
/*      */           
/*      */ 
/*      */           case 144: 
/* 2335 */             this.minsaveamt = _input_.readInt64();
/* 2336 */             break;
/*      */           
/*      */ 
/*      */           case 152: 
/* 2340 */             this.maxsaveamt = _input_.readInt64();
/* 2341 */             break;
/*      */           
/*      */ 
/*      */           case 160: 
/* 2345 */             this.noticetag = _input_.readInt32();
/* 2346 */             break;
/*      */           
/*      */ 
/*      */           case 168: 
/* 2350 */             this.badge = _input_.readBool();
/* 2351 */             break;
/*      */           
/*      */ 
/*      */           case 176: 
/* 2355 */             this.noticesortid = _input_.readInt32();
/* 2356 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 2360 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 2362 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 2371 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 2375 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 2377 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.IdipNoticeInfo copy()
/*      */     {
/* 2383 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.IdipNoticeInfo toData()
/*      */     {
/* 2389 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.IdipNoticeInfo toBean()
/*      */     {
/* 2394 */       return new IdipNoticeInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.IdipNoticeInfo toDataIf()
/*      */     {
/* 2400 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.IdipNoticeInfo toBeanIf()
/*      */     {
/* 2405 */       return new IdipNoticeInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 2411 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 2415 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 2419 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 2423 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 2427 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 2431 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 2435 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNoticetype()
/*      */     {
/* 2442 */       return this.noticetype;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDisplaytype()
/*      */     {
/* 2449 */       return this.displaytype;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHreftype()
/*      */     {
/* 2456 */       return this.hreftype;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getHreftext()
/*      */     {
/* 2463 */       return this.hreftext;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getHreftextOctets()
/*      */     {
/* 2470 */       return Octets.wrap(getHreftext(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getHrefurl()
/*      */     {
/* 2477 */       return this.hrefurl;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getHrefurlOctets()
/*      */     {
/* 2484 */       return Octets.wrap(getHrefurl(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSendtype()
/*      */     {
/* 2491 */       return this.sendtype;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getNoticetitle()
/*      */     {
/* 2498 */       return this.noticetitle;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getNoticetitleOctets()
/*      */     {
/* 2505 */       return Octets.wrap(getNoticetitle(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getNoticecontent()
/*      */     {
/* 2512 */       return this.noticecontent;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getNoticecontentOctets()
/*      */     {
/* 2519 */       return Octets.wrap(getNoticecontent(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getPictureurl()
/*      */     {
/* 2526 */       return this.pictureurl;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getPictureurlOctets()
/*      */     {
/* 2533 */       return Octets.wrap(getPictureurl(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStarttime()
/*      */     {
/* 2540 */       return this.starttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEndtime()
/*      */     {
/* 2547 */       return this.endtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMinopenserverdays()
/*      */     {
/* 2554 */       return this.minopenserverdays;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMaxopenserverdays()
/*      */     {
/* 2561 */       return this.maxopenserverdays;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMincreatroledays()
/*      */     {
/* 2568 */       return this.mincreatroledays;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMaxcreatroledays()
/*      */     {
/* 2575 */       return this.maxcreatroledays;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMinrolelevel()
/*      */     {
/* 2582 */       return this.minrolelevel;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMaxrolelevel()
/*      */     {
/* 2589 */       return this.maxrolelevel;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMinsaveamt()
/*      */     {
/* 2596 */       return this.minsaveamt;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMaxsaveamt()
/*      */     {
/* 2603 */       return this.maxsaveamt;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNoticetag()
/*      */     {
/* 2610 */       return this.noticetag;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getBadge()
/*      */     {
/* 2617 */       return this.badge;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNoticesortid()
/*      */     {
/* 2624 */       return this.noticesortid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNoticetype(int _v_)
/*      */     {
/* 2631 */       this.noticetype = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDisplaytype(int _v_)
/*      */     {
/* 2638 */       this.displaytype = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHreftype(int _v_)
/*      */     {
/* 2645 */       this.hreftype = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHreftext(String _v_)
/*      */     {
/* 2652 */       if (null == _v_)
/* 2653 */         throw new NullPointerException();
/* 2654 */       this.hreftext = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHreftextOctets(Octets _v_)
/*      */     {
/* 2661 */       setHreftext(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHrefurl(String _v_)
/*      */     {
/* 2668 */       if (null == _v_)
/* 2669 */         throw new NullPointerException();
/* 2670 */       this.hrefurl = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHrefurlOctets(Octets _v_)
/*      */     {
/* 2677 */       setHrefurl(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSendtype(int _v_)
/*      */     {
/* 2684 */       this.sendtype = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNoticetitle(String _v_)
/*      */     {
/* 2691 */       if (null == _v_)
/* 2692 */         throw new NullPointerException();
/* 2693 */       this.noticetitle = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNoticetitleOctets(Octets _v_)
/*      */     {
/* 2700 */       setNoticetitle(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNoticecontent(String _v_)
/*      */     {
/* 2707 */       if (null == _v_)
/* 2708 */         throw new NullPointerException();
/* 2709 */       this.noticecontent = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNoticecontentOctets(Octets _v_)
/*      */     {
/* 2716 */       setNoticecontent(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPictureurl(String _v_)
/*      */     {
/* 2723 */       if (null == _v_)
/* 2724 */         throw new NullPointerException();
/* 2725 */       this.pictureurl = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPictureurlOctets(Octets _v_)
/*      */     {
/* 2732 */       setPictureurl(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStarttime(long _v_)
/*      */     {
/* 2739 */       this.starttime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEndtime(long _v_)
/*      */     {
/* 2746 */       this.endtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMinopenserverdays(int _v_)
/*      */     {
/* 2753 */       this.minopenserverdays = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMaxopenserverdays(int _v_)
/*      */     {
/* 2760 */       this.maxopenserverdays = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMincreatroledays(int _v_)
/*      */     {
/* 2767 */       this.mincreatroledays = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMaxcreatroledays(int _v_)
/*      */     {
/* 2774 */       this.maxcreatroledays = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMinrolelevel(int _v_)
/*      */     {
/* 2781 */       this.minrolelevel = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMaxrolelevel(int _v_)
/*      */     {
/* 2788 */       this.maxrolelevel = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMinsaveamt(long _v_)
/*      */     {
/* 2795 */       this.minsaveamt = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMaxsaveamt(long _v_)
/*      */     {
/* 2802 */       this.maxsaveamt = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNoticetag(int _v_)
/*      */     {
/* 2809 */       this.noticetag = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBadge(boolean _v_)
/*      */     {
/* 2816 */       this.badge = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNoticesortid(int _v_)
/*      */     {
/* 2823 */       this.noticesortid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 2829 */       if (!(_o1_ instanceof Data)) return false;
/* 2830 */       Data _o_ = (Data)_o1_;
/* 2831 */       if (this.noticetype != _o_.noticetype) return false;
/* 2832 */       if (this.displaytype != _o_.displaytype) return false;
/* 2833 */       if (this.hreftype != _o_.hreftype) return false;
/* 2834 */       if (!this.hreftext.equals(_o_.hreftext)) return false;
/* 2835 */       if (!this.hrefurl.equals(_o_.hrefurl)) return false;
/* 2836 */       if (this.sendtype != _o_.sendtype) return false;
/* 2837 */       if (!this.noticetitle.equals(_o_.noticetitle)) return false;
/* 2838 */       if (!this.noticecontent.equals(_o_.noticecontent)) return false;
/* 2839 */       if (!this.pictureurl.equals(_o_.pictureurl)) return false;
/* 2840 */       if (this.starttime != _o_.starttime) return false;
/* 2841 */       if (this.endtime != _o_.endtime) return false;
/* 2842 */       if (this.minopenserverdays != _o_.minopenserverdays) return false;
/* 2843 */       if (this.maxopenserverdays != _o_.maxopenserverdays) return false;
/* 2844 */       if (this.mincreatroledays != _o_.mincreatroledays) return false;
/* 2845 */       if (this.maxcreatroledays != _o_.maxcreatroledays) return false;
/* 2846 */       if (this.minrolelevel != _o_.minrolelevel) return false;
/* 2847 */       if (this.maxrolelevel != _o_.maxrolelevel) return false;
/* 2848 */       if (this.minsaveamt != _o_.minsaveamt) return false;
/* 2849 */       if (this.maxsaveamt != _o_.maxsaveamt) return false;
/* 2850 */       if (this.noticetag != _o_.noticetag) return false;
/* 2851 */       if (this.badge != _o_.badge) return false;
/* 2852 */       if (this.noticesortid != _o_.noticesortid) return false;
/* 2853 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 2859 */       int _h_ = 0;
/* 2860 */       _h_ += this.noticetype;
/* 2861 */       _h_ += this.displaytype;
/* 2862 */       _h_ += this.hreftype;
/* 2863 */       _h_ += this.hreftext.hashCode();
/* 2864 */       _h_ += this.hrefurl.hashCode();
/* 2865 */       _h_ += this.sendtype;
/* 2866 */       _h_ += this.noticetitle.hashCode();
/* 2867 */       _h_ += this.noticecontent.hashCode();
/* 2868 */       _h_ += this.pictureurl.hashCode();
/* 2869 */       _h_ = (int)(_h_ + this.starttime);
/* 2870 */       _h_ = (int)(_h_ + this.endtime);
/* 2871 */       _h_ += this.minopenserverdays;
/* 2872 */       _h_ += this.maxopenserverdays;
/* 2873 */       _h_ += this.mincreatroledays;
/* 2874 */       _h_ += this.maxcreatroledays;
/* 2875 */       _h_ += this.minrolelevel;
/* 2876 */       _h_ += this.maxrolelevel;
/* 2877 */       _h_ = (int)(_h_ + this.minsaveamt);
/* 2878 */       _h_ = (int)(_h_ + this.maxsaveamt);
/* 2879 */       _h_ += this.noticetag;
/* 2880 */       _h_ += (this.badge ? 1231 : 1237);
/* 2881 */       _h_ += this.noticesortid;
/* 2882 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 2888 */       StringBuilder _sb_ = new StringBuilder();
/* 2889 */       _sb_.append("(");
/* 2890 */       _sb_.append(this.noticetype);
/* 2891 */       _sb_.append(",");
/* 2892 */       _sb_.append(this.displaytype);
/* 2893 */       _sb_.append(",");
/* 2894 */       _sb_.append(this.hreftype);
/* 2895 */       _sb_.append(",");
/* 2896 */       _sb_.append("'").append(this.hreftext).append("'");
/* 2897 */       _sb_.append(",");
/* 2898 */       _sb_.append("'").append(this.hrefurl).append("'");
/* 2899 */       _sb_.append(",");
/* 2900 */       _sb_.append(this.sendtype);
/* 2901 */       _sb_.append(",");
/* 2902 */       _sb_.append("'").append(this.noticetitle).append("'");
/* 2903 */       _sb_.append(",");
/* 2904 */       _sb_.append("'").append(this.noticecontent).append("'");
/* 2905 */       _sb_.append(",");
/* 2906 */       _sb_.append("'").append(this.pictureurl).append("'");
/* 2907 */       _sb_.append(",");
/* 2908 */       _sb_.append(this.starttime);
/* 2909 */       _sb_.append(",");
/* 2910 */       _sb_.append(this.endtime);
/* 2911 */       _sb_.append(",");
/* 2912 */       _sb_.append(this.minopenserverdays);
/* 2913 */       _sb_.append(",");
/* 2914 */       _sb_.append(this.maxopenserverdays);
/* 2915 */       _sb_.append(",");
/* 2916 */       _sb_.append(this.mincreatroledays);
/* 2917 */       _sb_.append(",");
/* 2918 */       _sb_.append(this.maxcreatroledays);
/* 2919 */       _sb_.append(",");
/* 2920 */       _sb_.append(this.minrolelevel);
/* 2921 */       _sb_.append(",");
/* 2922 */       _sb_.append(this.maxrolelevel);
/* 2923 */       _sb_.append(",");
/* 2924 */       _sb_.append(this.minsaveamt);
/* 2925 */       _sb_.append(",");
/* 2926 */       _sb_.append(this.maxsaveamt);
/* 2927 */       _sb_.append(",");
/* 2928 */       _sb_.append(this.noticetag);
/* 2929 */       _sb_.append(",");
/* 2930 */       _sb_.append(this.badge);
/* 2931 */       _sb_.append(",");
/* 2932 */       _sb_.append(this.noticesortid);
/* 2933 */       _sb_.append(")");
/* 2934 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\IdipNoticeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */